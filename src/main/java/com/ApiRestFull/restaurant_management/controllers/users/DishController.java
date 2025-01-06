package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.Dish;
import com.ApiRestFull.restaurant_management.services.DishService;
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
@RequestMapping("api/dish")
public class DishController {

    private final DishService service;

    @Autowired
    public DishController(DishService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Dish>> findAllDishes(){
        return ResponseEntity.ok(service.ListDishes());
    }

    @PostMapping("/add")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish){
        service.addDish(dish);
        System.out.println("Plato añadido exitosamente");
        return ResponseEntity.ok(dish);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> removeDish(@PathVariable Long id){
        service.removeDish(id);
        System.out.println("Plato eliminado con exito");
        return ResponseEntity.ok("Producto eliminado con exito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findDishById(@PathVariable Long id){
        return ResponseEntity.ok(service.findDishById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish dish){
        System.out.println("Plato actualizado con exito " + dish.getName());
        return ResponseEntity.ok(service.editDish(id, dish));
    }



}
