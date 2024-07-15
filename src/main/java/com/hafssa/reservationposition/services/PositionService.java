package com.hafssa.reservationposition.services;


import com.hafssa.reservationposition.dtos.PositionDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PositionService {

    List<PositionDto> getAllPositions();
    PositionDto getPositionById(int id);
}
