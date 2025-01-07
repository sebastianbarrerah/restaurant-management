package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.Restaurant;
import com.ApiRestFull.restaurant_management.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> ListRestaurants(){
        return repository.findAll();
    }

    public void addRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public void removeRestaurant(Long id) {
        repository.deleteById(id);
    }

    public Restaurant findRestaurantById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Restaurant editRestaurant(Long id, Restaurant restaurant) {
        return repository.findById(id).map(restaurante -> {
            restaurante.setName(restaurant.getName());
            restaurante.setDescription(restaurant.getDescription());
            restaurante.setAddress(restaurant.getAddress());
            restaurante.setPhone(restaurant.getPhone());
            restaurante.setCity(restaurant.getCity());
            restaurante.setMenus(restaurant.getMenus());
            return  repository.save(restaurante);
        }).orElse(null);
    }

}
