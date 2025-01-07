package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private String address;
    private Boolean isFrequent;
}
