package com.ApiRestFull.restaurant_management.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequestDto {
    private String name;
    private String description;
    private Integer price;
    private Boolean isPopular;
}

