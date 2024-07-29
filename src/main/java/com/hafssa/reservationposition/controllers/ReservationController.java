package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.ReservationDto;
import com.hafssa.reservationposition.entities.Position;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    @Autowired
    private ReservationService reservationService;
    private Position position;

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

    @PostMapping("/reserve")
    public ResponseEntity<?> reserve(@RequestBody ReservationDto reservationDto) {
        try {
            // Log les données reçues pour vérifier le format
            logger.info("Received reservation request: {}", reservationDto);

            if (reservationDto.getDateDeb() == null || reservationDto.getDateFin() == null ||
                    reservationDto.getUserId() == null || reservationDto.getPositionId() == null ||
                    reservationDto.getPositionNumero() == null || reservationDto.getFirstName() == null ||
                    reservationDto.getLastName() == null) {
                return ResponseEntity.badRequest().body("Données invalides fournies.");
            }

            // Utiliser la méthode createReservation du service au lieu de save
            ReservationDto createdReservation = reservationService.createReservation(reservationDto);
            logger.info("Reservation created successfully");
            return ResponseEntity.ok(new SuccessResponse("Réservation créée avec succès !"));
        } catch (IllegalArgumentException e) {
            System.err.println("Error processing reservation: " + e.getMessage());
            return ResponseEntity.badRequest().body("Données invalides fournies.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return ResponseEntity.status(500).body("Une erreur inattendue est survenue.");
        }
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
// Créez une classe pour les réponses de succès
class SuccessResponse {
    private String message;

    public SuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

