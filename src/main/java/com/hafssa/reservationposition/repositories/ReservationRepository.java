package com.hafssa.reservationposition.repositories;

import com.hafssa.reservationposition.dtos.OccupancyDto;
import com.hafssa.reservationposition.entities.Position;
import com.hafssa.reservationposition.entities.Reservation;
import com.hafssa.reservationposition.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByDateDeb(Instant dateDeb);

    @Query(value = "SELECT r.date_deb, COUNT(*)*100 / :totalPositions  FROM reservation r WHERE r.date_deb BETWEEN :startDate AND :endDate GROUP BY r.date_deb", nativeQuery = true)
    List<Object[]> findOccupancyRateByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("totalPositions") long totalPositions);

    Optional<Reservation> findByUser(User user);
}