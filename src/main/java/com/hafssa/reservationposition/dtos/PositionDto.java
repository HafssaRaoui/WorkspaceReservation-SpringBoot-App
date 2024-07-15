package com.hafssa.reservationposition.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.hafssa.reservationposition.entities.Position}
 */
public class PositionDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 45)
    private final String numero;
    private final Set<ReservationDto> reservations;

    public PositionDto(Integer id, String numero, Set<ReservationDto> reservations) {
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

    public Set<ReservationDto> getReservations() {
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
}