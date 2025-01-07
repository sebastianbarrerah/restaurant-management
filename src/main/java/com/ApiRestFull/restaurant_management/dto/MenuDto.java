package com.ApiRestFull.restaurant_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuDto {
        private String name;
        private String description;
        private Long restaurantId;
        private List<Long> dishIds;
}
