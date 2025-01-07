package utils;


import com.ApiRestFull.restaurant_management.dto.DishRequestDto;
import com.ApiRestFull.restaurant_management.dto.DishResponseDto;
import com.ApiRestFull.restaurant_management.model.Dish;

public class DishDtoConverter {

    public static DishResponseDto convertToResponseDto(Dish dish) {
        DishResponseDto dto = new DishResponseDto();
        dto.setId(dish.getId());
        dto.setName(dish.getName());
        dto.setDescription(dish.getDescription());
        dto.setPrice(dish.getPrice());
        dto.setIsPopular(dish.getIsPopular());
        return dto;
    }

    public static Dish convertToEntity(DishRequestDto dishRequestDto) {
        Dish dish = new Dish();
        dish.setName(dishRequestDto.getName());
        dish.setDescription(dishRequestDto.getDescription());
        dish.setPrice(dishRequestDto.getPrice());
        dish.setIsPopular(dishRequestDto.getIsPopular());
        return dish;
    }
}
