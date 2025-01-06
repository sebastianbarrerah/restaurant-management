package com.ApiRestFull.restaurant_management.controllers.users;

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

import java.util.List;

@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {

    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> findAllRestaurants(){
        return ResponseEntity.ok(service.ListRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(@PathVariable Long id){
        return ResponseEntity.ok(service.findRestaurantById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant){
        service.addRestaurant(restaurant);
        return ResponseEntity.ok("Restaurante agregado con exito");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Restaurant> editRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        return ResponseEntity.ok(service.editRestaurant(id, restaurant));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> removeRestaurant(@PathVariable Long id){
        service.removeRestaurant(id);
        return ResponseEntity.ok("Restaurante eliminado con exito");
    }
}
