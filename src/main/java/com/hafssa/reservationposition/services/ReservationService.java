package com.hafssa.reservationposition.services;


import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.entities.User;

import java.time.Instant;
import java.util.List;
import java.util.Map;


public interface ReservationService {

    List<ReservationDto> getAllReservations();
    ReservationDto getReservationById(int id);
    ReservationDto createReservation(ReservationDto reservationDto);
    void deleteReservation(int id);
    List<ReservationDto> getReservationsByDate(Instant date);
    public List<Object[]> getOccupancyForNextTwoWeeks();
    public ReservationDto convertToDto(Reservation reservation);


    Reservation save(Reservation reservation);
}
