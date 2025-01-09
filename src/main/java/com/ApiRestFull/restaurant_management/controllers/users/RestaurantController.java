package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.dto.RestaurantRequestDto;
import com.ApiRestFull.restaurant_management.dto.RestaurantResponseDto;
import com.ApiRestFull.restaurant_management.model.Restaurant;
import com.ApiRestFull.restaurant_management.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.RestaurantDtoConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {

    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<RestaurantResponseDto>> findAllRestaurants(){
        List<Restaurant> restaurants = service.ListRestaurants();
        List<RestaurantResponseDto> response = restaurants.stream()
                .map(RestaurantDtoConverter::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> findRestaurantById(@PathVariable Long id){
        Restaurant restaurant = service.findRestaurantById(id);
        return ResponseEntity.ok(RestaurantDtoConverter.convertToResponseDto(restaurant));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){
        Restaurant restaurant = RestaurantDtoConverter.convertToEntity(restaurantRequestDto);
        service.addRestaurant(restaurant);
        return ResponseEntity.ok("Restaurante agregado con éxito.");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<RestaurantResponseDto> editRestaurant(@PathVariable Long id, @RequestBody RestaurantRequestDto restaurantRequestDto){
        Restaurant restaurant = RestaurantDtoConverter.convertToEntity(restaurantRequestDto);
        Restaurant updatedRestaurant = service.editRestaurant(id, restaurant);
        return ResponseEntity.ok(RestaurantDtoConverter.convertToResponseDto(updatedRestaurant));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> removeRestaurant(@PathVariable Long id){
        service.removeRestaurant(id);
        return ResponseEntity.ok("Restaurante eliminado con éxito.");
    }
}
