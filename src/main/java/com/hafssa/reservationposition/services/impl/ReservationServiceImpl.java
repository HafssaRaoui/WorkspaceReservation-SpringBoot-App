package com.hafssa.reservationposition.services.impl;


import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.dtos.UserDto;
import com.hafssa.reservationposition.entities.Position;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.repositories.ReservationRepository;
import com.hafssa.reservationposition.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;



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
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = convertToEntity(reservationDto);
        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDto(savedReservation);
    }




    @Override
    public void deleteReservation(int id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        }

    }



    private ReservationDto convertToDto(Reservation reservation) {
          return new ReservationDto(
                reservation.getId(),
                reservation.getDateDeb(),
                reservation.getDateFin(),
                new UserDto(reservation.getUser().getId(), reservation.getUser().getMatricule(),
                        reservation.getUser().getFirstName(), reservation.getUser().getLastName(),
                        reservation.getUser().getRole(), reservation.getUser().getEmail(),
                        reservation.getUser().getPassword()),
                new PositionDto(reservation.getPosition().getId(), reservation.getPosition().getNumero(), null)
        );
    }



    private Reservation convertToEntity(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setDateDeb(reservationDto.getDateDeb());
        reservation.setDateFin(reservationDto.getDateFin());
        reservation.setUser(new User());
        reservation.getUser().setId(reservationDto.getUser().getId());
        reservation.setPosition(new Position());
        reservation.getPosition().setId(reservationDto.getPosition().getId());
        return reservation;
    }




}
