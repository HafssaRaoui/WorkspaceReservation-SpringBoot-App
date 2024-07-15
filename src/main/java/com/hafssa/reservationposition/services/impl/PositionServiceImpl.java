package com.hafssa.reservationposition.services.impl;

import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.entities.Position;
import com.hafssa.reservationposition.repositories.PositionRepository;
import com.hafssa.reservationposition.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PositionServiceImpl implements PositionService {


    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<PositionDto> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }



    @Override
    public PositionDto getPositionById(int id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found"));
        return convertToDto(position);
    }


    private PositionDto convertToDto(Position position) {
        return new PositionDto(position.getId(), position.getNumero(), null);
    }
}
