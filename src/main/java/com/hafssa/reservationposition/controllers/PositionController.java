package com.hafssa.reservationposition.controllers;

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
public class PositionController {

    @Autowired
    private PositionService positionService;


    @Autowired
    private PositionService reservationService;

    @GetMapping
    public List<PositionDto> getAllPositions() {
        return positionService.getAllPositions();
    }

/*
    @GetMapping("/{date}") // format date à préciser Y-m-d"
    public List<PositionDto> getAllPositionsStatus(@PathVariable String date) {
        List <PositionDto> positions = positionService.getAllPositions();
        Instant dateconverted = new Date(date).toInstant();

        /
        List<ReservationDto> reservations=  reservationService.getPositionByDate(dateconverted);

        // parcourir les reservations et pour chaque position trouvée lui ajouter l'objet reservation correspondant.
        // retourner l'objet positions.
    }
*/


    @GetMapping("/reserved")
    public List<PositionDto> getPositionsByDate(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        Instant dateInstant;
        if (date == null) {
            dateInstant = Instant.now();
        } else {
            dateInstant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        }

        return positionService.getPositionsByDate(dateInstant);
    }

    @GetMapping("/{id}")
    public PositionDto getPositionById(@PathVariable Integer id) {
        return positionService.getPositionById(id);
    }






}
