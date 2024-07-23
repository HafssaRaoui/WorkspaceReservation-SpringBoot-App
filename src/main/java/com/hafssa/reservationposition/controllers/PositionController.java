package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.OccupancyDto;
import com.hafssa.reservationposition.dtos.PositionDto;
import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
