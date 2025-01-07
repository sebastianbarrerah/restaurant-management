package com.ApiRestFull.restaurant_management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Integer total;
    private Integer amountUsers;

    @Enumerated(EnumType.STRING)
    private StatusReservation status;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private Users user;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonManagedReference
    private Restaurant restaurant;



    public Reservation() {}

    public Reservation(String date,  Integer amountUsers, Users user, Restaurant restaurant) {
        this.date = date;
        this.amountUsers = amountUsers;
        this.status = StatusReservation.PENDING;
        this.user = user;
        this.restaurant = restaurant;
    }

}
