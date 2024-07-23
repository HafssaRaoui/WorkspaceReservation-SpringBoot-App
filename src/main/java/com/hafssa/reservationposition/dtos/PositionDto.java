package com.hafssa.reservationposition.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.hafssa.reservationposition.entities.Position}
 */
public class PositionDto implements Serializable {
    @NotNull
    private final Integer id;

    @Size(max = 45)
    private final String numero;
    private List<ReservationDto> reservations;

    public PositionDto(Integer id, String numero, List<ReservationDto> reservations) {
        this.id = id;
        this.numero = numero;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionDto entity = (PositionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.reservations, entity.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, reservations);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "numero = " + numero + ", " +
                "reservations = " + reservations + ")";
    }

    public void setReservations(List<ReservationDto> positionReservations) {
        this.reservations = positionReservations;
    }
}