package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.Entity;
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
    private Integer ammountUsers;
    private StatusReservation status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Users client;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurant restaurant;

    public Reservation() {}

    public Reservation(Long id, String date, Integer total, Integer ammountUsers, StatusReservation status, Users client, Restaurant restaurant) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.ammountUsers = ammountUsers;
        this.status = status;
        this.client = client;
        this.restaurant = restaurant;
    }

}
