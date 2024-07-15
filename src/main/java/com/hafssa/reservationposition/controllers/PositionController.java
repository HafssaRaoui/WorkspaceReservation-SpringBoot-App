package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<PositionDto> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/{id}")
    public PositionDto getPositionById(@PathVariable Integer id) {
        return positionService.getPositionById(id);
    }

}
