package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/positions")
@CrossOrigin(origins = "http://localhost:56578")
public class PositionController {

    @Autowired
    private PositionService positionService;


    @Autowired
    private PositionService reservationService;

    @GetMapping
    public List<PositionDto> getAllPositions() {
        return positionService.getAllPositions();
    }


    @GetMapping("/reserved")
    public List<PositionDto> getPositionsByDate(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        LocalDate queryDate;
        if (date == null) {
            queryDate = LocalDate.now();
        } else {
            queryDate = date;
        }

        return positionService.getPositionsByDate(queryDate);
    }





    @GetMapping("/{id}")
    public PositionDto getPositionById(@PathVariable Integer id) {
        return positionService.getPositionById(id);
    }

}
