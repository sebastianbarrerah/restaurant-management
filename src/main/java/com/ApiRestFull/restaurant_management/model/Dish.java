package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;

    @Column(nullable = false)
    private Boolean isPopular = false;



    public Dish() {}

    public Dish(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isPopular = false;
    }

}
