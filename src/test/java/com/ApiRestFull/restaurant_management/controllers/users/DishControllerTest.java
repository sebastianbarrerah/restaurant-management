package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.Dish;
import com.ApiRestFull.restaurant_management.services.DishService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DishControllerTest {

    private final WebTestClient webTestClient;
    private final DishService dishService;

    DishControllerTest(DishService dishService){
        this.dishService = dishService;
        dishesServices = mock(DishService.class);
        webTestClient = WebTestClient.bindToController(new DishController(dishesServices)).build();
    }

    @Test
    @DisplayName("Buscar todos los platos")
    void findAllDishes() {
        List<Dish> dishes = listDishes();



    }

    @Test
    @DisplayName("Buscar todos los platos")
    void addDish() {
    }

    @Test
    void removeDish() {
    }

    @Test
    void findDishById() {
    }

    @Test
    void updateDish() {
    }

    private List<Dish>listDishes(){
        return List.of(
                new Dish("plato frijoles", "frijoles caseros", 25000),
                new Dish("plato lentejas", "lentejas santandereanas", 25000),
                new Dish("plato pastas", "pastas bolognesa", 25000)
                );
    }
}