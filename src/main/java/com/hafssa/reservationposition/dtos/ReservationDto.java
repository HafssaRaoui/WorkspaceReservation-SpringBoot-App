package com.hafssa.reservationposition.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.hafssa.reservationposition.entities.Reservation}
 */
public class ReservationDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Instant dateDeb;
    @NotNull
    private final Instant dateFin;
    @NotNull
    private final UserDto user;
    @NotNull
    private final PositionDto position;

    public ReservationDto(Integer id, Instant dateDeb, Instant dateFin, UserDto user, PositionDto position) {
        this.id = id;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.user = user;
        this.position = position;
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

    public UserDto getUser() {
        return user;
    }

    public PositionDto getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDto entity = (ReservationDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dateDeb, entity.dateDeb) &&
                Objects.equals(this.dateFin, entity.dateFin) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.position, entity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDeb, dateFin, user, position);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateDeb = " + dateDeb + ", " +
                "dateFin = " + dateFin + ", " +
                "user = " + user + ", " +
                "position = " + position + ")";
    }
}