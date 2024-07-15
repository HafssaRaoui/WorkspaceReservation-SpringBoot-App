package com.hafssa.reservationposition.repositories;

import com.hafssa.reservationposition.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}