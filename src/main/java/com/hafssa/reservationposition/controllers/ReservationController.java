package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:56578")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.createReservation(reservationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }

   /* @GetMapping("/occupancy")
    public List<Object[]> getOccupancyForNextTwoWeeks() {
        return reservationService.getOccupancyForNextTwoWeeks();
    }*/

/*
    @GetMapping("/sendOccupancyReport")
    public String sendOccupancyReport(@RequestParam String toEmail) {
        // Retrieve the occupancy data
        Map<LocalDate, Double> occupancyMap = (Map<LocalDate, Double>) reservationService.getOccupancyForNextTwoWeeks(); // Implement this method to return Map<LocalDate, Double>

        // Send the email
        emailOccupancyService.generateAndSendOccupancyEmail(occupancyMap, toEmail, "Occupancy Report");

        return "Occupancy report sent to " + toEmail;
    }*/

}
