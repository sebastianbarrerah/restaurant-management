package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.dto.DishRequestDto;
import com.ApiRestFull.restaurant_management.dto.DishResponseDto;
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
import utils.DishDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/dish")
public class DishController {

    private final DishService service;

    @Autowired
    public DishController(DishService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<DishResponseDto>> findAllDishes(){
        List<Dish> dishes = service.ListDishes();
        List<DishResponseDto> response = dishes.stream()
                .map(DishDtoConverter::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDish(@RequestBody DishRequestDto dishRequestDTO){
        Dish dish = DishDtoConverter.convertToEntity(dishRequestDTO);
        service.addDish(dish);
        System.out.println("Plato añadido exitosamente");
        return ResponseEntity.ok("Plato añadido exitosamente.");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> removeDish(@PathVariable Long id){
        service.removeDish(id);
        System.out.println("Plato eliminado con exito");
        return ResponseEntity.ok("Plato eliminado con exito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishResponseDto> findDishById(@PathVariable Long id){
        Dish dish = service.findDishById(id);
        return ResponseEntity.ok(DishDtoConverter.convertToResponseDto(dish));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DishResponseDto> updateDish(@PathVariable Long id, @RequestBody DishRequestDto dishRequestDto){
        Dish dish = DishDtoConverter.convertToEntity(dishRequestDto);
        Dish updatedDish = service.editDish(id, dish);
        return ResponseEntity.ok(DishDtoConverter.convertToResponseDto(updatedDish));
    }
}
