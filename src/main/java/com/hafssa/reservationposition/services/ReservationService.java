package com.hafssa.reservationposition.services;


import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.entities.Reservation;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;



public interface ReservationService {

    List<ReservationDto> getAllReservations();
    ReservationDto getReservationById(int id);
    ReservationDto createReservation(ReservationDto reservationDto);
    void deleteReservation(int id);
    List<ReservationDto> getReservationsByDate(Instant date);
    public ReservationDto convertToDto(Reservation reservation);


}
