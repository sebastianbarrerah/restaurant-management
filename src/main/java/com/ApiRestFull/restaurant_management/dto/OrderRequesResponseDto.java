package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequesResponseDto {
    private Long id;
    private String date;
    private Integer total;
    private Long userId;
}
