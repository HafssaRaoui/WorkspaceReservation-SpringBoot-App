package com.hafssa.reservationposition.services;


import com.hafssa.reservationposition.dtos.OccupancyDto;
import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.entities.Reservation;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface PositionService {

    List<PositionDto> getAllPositions();
    PositionDto getPositionById(int id);
    public List<PositionDto> getPositionsByDate(LocalDate date);


}
