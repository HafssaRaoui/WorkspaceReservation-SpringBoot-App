package com.hafssa.reservationposition.services.impl;


import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.entities.Position;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.repositories.PositionRepository;
import com.hafssa.reservationposition.repositories.ReservationRepository;
import com.hafssa.reservationposition.repositories.UserRepository;
import com.hafssa.reservationposition.services.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;







    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDto getReservationById(int id) {
        return reservationRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    @Transactional
    public ReservationDto createReservation(ReservationDto reservationDto) {

        // Trouver l'utilisateur et la position
        User user = userRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Position position = positionRepository.findById(reservationDto.getPositionId())
                .orElseThrow(() -> new IllegalArgumentException("Position not found"));

        // Annuler la réservation existante de l'utilisateur
        cancelExistingReservation(user);

        // Créer la nouvelle réservation
        Reservation reservation = convertToEntity(reservationDto);
        reservation.setUser(user);
        reservation.setPosition(position);

        Reservation savedReservation = reservationRepository.save(reservation);

        return convertToDto(savedReservation);
    }






    @Override
    public void deleteReservation(int id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        }


    }

    @Override

    public List<ReservationDto> getReservationsByDate(Instant date) {
        List<Reservation> reservations = reservationRepository.findByDateDeb(date);
        return reservations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Object[]> getOccupancyForNextTwoWeeks() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(14);
        long totalPositions = positionRepository.count();
        return reservationRepository.findOccupancyRateByDateRange(startDate, endDate, totalPositions);
    }




    public ReservationDto convertToDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getDateDeb(),
                reservation.getDateFin(),
                reservation.getUser().getId(),
                reservation.getPosition().getId(),
                reservation.getUser().getFirstName(),
                reservation.getUser().getLastName(),
                reservation.getPosition().getNumero());

    }

    @Transactional
    public Reservation save(Reservation reservation) {
        // Vérifier et récupérer l'utilisateur
        User user = userRepository.findById(reservation.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        // Mettre à jour les informations de l'utilisateur si nécessaire
        user.setFirstName(reservation.getUser().getFirstName());
        user.setLastName(reservation.getUser().getLastName());
        user = userRepository.save(user);

        // Vérifier et récupérer la position
        Position position = positionRepository.findById(reservation.getPosition().getId())
                .orElseThrow(() -> new EntityNotFoundException("Position non trouvée"));

        // Créer et sauvegarder la réservation
        Reservation newReservation = new Reservation();
        newReservation.setDateDeb(reservation.getDateDeb());
        newReservation.setDateFin(reservation.getDateFin());
        newReservation.setUser(user);
        newReservation.setPosition(position);

        return reservationRepository.save(newReservation);
    }






    private Reservation convertToEntity(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setDateDeb(reservationDto.getDateDeb());
        reservation.setDateFin(reservationDto.getDateFin());
        reservation.setUser(new User());
        reservation.getUser().setId(reservationDto.getUserId());
        reservation.setPosition(new Position());
        reservation.getPosition().setId(reservationDto.getPositionId());
        return reservation;
    }


    @Transactional
    public void cancelExistingReservation(User user) {
        // Trouver la réservation existante de l'utilisateur
        Reservation existingReservation = reservationRepository.findByUser(user)
                .orElse(null);

        if (existingReservation != null) {
            // Annuler la réservation existante
            reservationRepository.delete(existingReservation);
        }
    }


}
