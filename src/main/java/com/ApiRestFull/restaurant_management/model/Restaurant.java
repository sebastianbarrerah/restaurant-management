package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Getter
    @Setter
    public class Restaurant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private String address;
        private Integer phone;
        private String city;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        private List<Menu> menus = new ArrayList<>();

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        private List<Reservation> reservas = new ArrayList<>();

        public Restaurant() {}

        public Restaurant( String name, String description, String address, Integer phone, String city) {
            this.name = name;
            this.description = description;
            this.address = address;
            this.phone = phone;
            this.city = city;
        }

}