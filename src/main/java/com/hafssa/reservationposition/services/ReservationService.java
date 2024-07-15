package com.hafssa.reservationposition.services;


import com.hafssa.reservationposition.dtos.ReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ReservationService {

    List<ReservationDto> getAllReservations();
    ReservationDto getReservationById(int id);
    ReservationDto createReservation(ReservationDto reservationDto);
    void deleteReservation(int id);


}
