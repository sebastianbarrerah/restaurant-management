package com.ApiRestFull.restaurant_management.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Boolean isPopular;
}
