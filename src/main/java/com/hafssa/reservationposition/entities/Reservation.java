package com.hafssa.reservationposition.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "date_deb", nullable = false)
    private Instant dateDeb;


    @Column(name = "date_fin", nullable = false)
    private Instant dateFin;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "Position_id", nullable = false)
    @JsonManagedReference
    private Position position;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Instant getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Instant dateDeb) {
        this.dateDeb = dateDeb;
    }

    public @NotNull Instant getDateFin() {
        return dateFin;
    }

    public void setDateFin(Instant dateFin) {
        this.dateFin = dateFin;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setUserId(Integer userId) {
        if (this.user == null) {
            this.user = new User(); // Initialize user if it is null
        }
        this.user.setId(userId);
    }
    public void setUserFirstName(String userFirstName) {
        if (this.user == null) {
            this.user = new User(); // Initialize user if it is null
        }
        this.user.setFirstName(userFirstName);
    }
    public void setUserLastName(String userLastName) {
        if (this.user == null) {
            this.user = new User(); // Initialize user if it is null
        }
        this.user.setLastName(userLastName);
    }
    public void setPositionId(Integer positionId) {
        this.position.setId(positionId);
    }

    public String getUserFirstName() {
        return  this.getUser().getFirstName();
    }
    public String getUserLastName() {
        return  this.getUser().getLastName();
    }
    public Integer getUserId() {
        return  this.getUser().getId();
    }

    public Integer getPositionId() {
        return  this.getPosition().getId();
    }
}