package utils;


import com.ApiRestFull.restaurant_management.dto.RestaurantRequestDto;
import com.ApiRestFull.restaurant_management.dto.RestaurantResponseDto;
import com.ApiRestFull.restaurant_management.model.Restaurant;

public class RestaurantDtoConverter {

    public static RestaurantResponseDto convertToResponseDto(Restaurant restaurant) {
        RestaurantResponseDto dto = new RestaurantResponseDto();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setDescription(restaurant.getDescription());
        dto.setAddress(restaurant.getAddress());
        dto.setPhone(restaurant.getPhone());
        dto.setCity(restaurant.getCity());
        return dto;
    }

    public static Restaurant convertToEntity(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequestDto.getName());
        restaurant.setDescription(restaurantRequestDto.getDescription());
        restaurant.setAddress(restaurantRequestDto.getAddress());
        restaurant.setPhone(restaurantRequestDto.getPhone());
        restaurant.setCity(restaurantRequestDto.getCity());
        return restaurant;
    }
}
