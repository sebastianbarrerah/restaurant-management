package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.Dish;
import com.ApiRestFull.restaurant_management.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    public List<Dish> ListDishes(){
        return dishRepository.findAll();
    }

    public Dish findDishById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    public void removeDish(Long id) {
        dishRepository.deleteById(id);
    }

    public Dish editDish(Long id, Dish dish){
        return dishRepository.findById(id).map(plato -> {
            plato.setDescription(dish.getDescription());
            plato.setName(dish.getName());
            plato.setPrice(dish.getPrice());
            plato.setIsPopular(dish.getIsPopular());
            return dishRepository.save(plato);
        }).orElse(null);
    }





}
