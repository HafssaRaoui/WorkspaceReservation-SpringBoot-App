package com.hafssa.reservationposition.repositories;

import com.hafssa.reservationposition.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}