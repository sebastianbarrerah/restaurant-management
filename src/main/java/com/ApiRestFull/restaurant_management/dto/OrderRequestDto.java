package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private String date;
    private Long userId;
}
