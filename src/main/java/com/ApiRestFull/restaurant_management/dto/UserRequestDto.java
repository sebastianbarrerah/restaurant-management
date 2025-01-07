package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    private String email;
    private Integer phone;
    private String address;
    private Boolean isFrequent;
}
