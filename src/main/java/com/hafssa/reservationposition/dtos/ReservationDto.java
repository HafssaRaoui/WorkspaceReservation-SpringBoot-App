package com.hafssa.reservationposition.dtos;

import java.io.Serializable;
import java.time.Instant;

public class ReservationDto implements Serializable {


    private  Instant dateDeb;

    private  Instant dateFin;


    private  Integer userId;

    private  Integer positionId;

    private  String positionNumero;

    private  String firstName;

    private  String lastName;
    public ReservationDto() {
    }


    public ReservationDto( Instant dateDeb, Instant dateFin, Integer id1, Integer id2,String firstName,String lastName,String numero) {
        this.dateDeb=dateDeb;
        this.dateFin=dateFin;
        this.userId=id1;
        this.positionId=id2;
        this.firstName=firstName;
        this.lastName=lastName;
        this.positionNumero=numero;
    }




    public Instant getDateDeb() {
        return dateDeb;
    }



    public Instant getDateFin() {
        return dateFin;
    }



    public  String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }

    public  String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPositionId() {
        return positionId;
    }



    public void setDateDeb( Instant dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin( Instant dateFin) {
        this.dateFin = dateFin;
    }


    public void setUserId( Integer userId) {
        this.userId = userId;
    }

    public void setPositionId( Integer positionId) {
        this.positionId = positionId;
    }

    public  String getPositionNumero() {
        return positionNumero;
    }

    public void setPositionNumero( String positionNumero) {
        this.positionNumero = positionNumero;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "dateDeb=" + dateDeb +
                ", dateFin=" + dateFin +
                ", userId=" + userId +
                ", positionId=" + positionId +
                ", positionNumero='" + positionNumero + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
