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
    @NotNull
    private final String first_name;
    @NotNull
    private final String last_name;

    public ReservationDto(Integer id, Instant dateDeb, Instant dateFin, Integer userId, Integer positionId, String first_name,String last_name) {
        this.id = id;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.userId = userId;
        this.first_name=first_name;
        this.last_name=last_name;
        this.positionId = positionId;
    }



    public Integer getId() {
        return id;
    }

    public Instant getDateDeb() {
        return dateDeb;
    }

    public @NotNull String getFirst_name() {
        return first_name;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public @NotNull String getLast_name() {
        return last_name;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPositionId() {
        return positionId;
    }

}
