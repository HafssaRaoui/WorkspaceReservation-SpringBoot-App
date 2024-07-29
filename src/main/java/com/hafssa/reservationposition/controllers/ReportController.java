package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.repositories.PositionRepository;
import com.hafssa.reservationposition.repositories.ReservationRepository;
import com.hafssa.reservationposition.services.EmailContentService;
import com.hafssa.reservationposition.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EmailContentService emailContentService;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ReservationRepository reservationRepository;



    @GetMapping("/Occupancy")
    public List<Object[]> getOccupancy() {

        return reservationService.getOccupancyForNextTwoWeeks();
    }

    @GetMapping("/sendOccupancyReport")
    public String sendOccupancyReport(@RequestParam String toEmail) {

        List<Object[]> occupancyList = reservationService.getOccupancyForNextTwoWeeks();

        // Envoyer l'email
        emailContentService.generateAndSendOccupancyEmail(occupancyList, toEmail, "Occupancy Report");

        return "Occupancy report sent to " + toEmail;
    }
}
