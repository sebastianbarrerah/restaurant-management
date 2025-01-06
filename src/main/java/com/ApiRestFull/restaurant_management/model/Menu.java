package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurant restaurant;


    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    public Menu() {}

    public Menu( String name, String description, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.restaurant = restaurant;
    }

}
