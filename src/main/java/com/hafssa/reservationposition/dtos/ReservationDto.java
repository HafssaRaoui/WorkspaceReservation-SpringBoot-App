package com.hafssa.reservationposition.dtos;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.chrono.ChronoLocalDate;

public class ReservationDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Instant dateDeb;
    @NotNull
    private final Instant dateFin;
    @NotNull
    private final Integer userId;
    @NotNull
    private final Integer positionId;

    public ReservationDto(Integer id, Instant dateDeb, Instant dateFin, Integer userId, Integer positionId) {
        this.id = id;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.userId = userId;
        this.positionId = positionId;
    }



    public Integer getId() {
        return id;
    }

    public Instant getDateDeb() {
        return dateDeb;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPositionId() {
        return positionId;
    }

}
