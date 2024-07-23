package com.hafssa.reservationposition.dtos;

import java.time.LocalDate;

public class OccupancyDto {
    private LocalDate date;
    private double occupancyPercentage;

    public OccupancyDto(LocalDate date, double occupancyPercentage) {
        this.date = date;
        this.occupancyPercentage = occupancyPercentage;
    }

    // getters & setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getOccupancyPercentage() {
        return occupancyPercentage;
    }

    public void setOccupancyPercentage(double occupancyPercentage) {
        this.occupancyPercentage = occupancyPercentage;
    }
}
