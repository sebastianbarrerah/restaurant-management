package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

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


    @ManyToMany
    @JoinTable(
            name = "menu_dish",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    public Menu() {}

    public Menu( String name, String description, Restaurant restaurant, List<Dish> dishes) {
        this.name = name;
        this.description = description;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

}
