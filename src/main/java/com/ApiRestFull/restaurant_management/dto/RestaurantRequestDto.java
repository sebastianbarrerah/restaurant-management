package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDto {
    private String name;
    private String description;
    private String address;
    private Integer phone;
    private String city;
}
