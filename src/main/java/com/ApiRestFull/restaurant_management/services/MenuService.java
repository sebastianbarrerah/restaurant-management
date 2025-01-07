package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.dto.MenuDto;
import com.ApiRestFull.restaurant_management.model.Dish;
import com.ApiRestFull.restaurant_management.model.Menu;
import com.ApiRestFull.restaurant_management.model.Restaurant;
import com.ApiRestFull.restaurant_management.repositories.DishRepository;
import com.ApiRestFull.restaurant_management.repositories.MenuRepository;
import com.ApiRestFull.restaurant_management.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    public void addMenu(MenuDto menuDTO) {
        Restaurant restaurant = restaurantRepository.findById(menuDTO.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante no encontrado"));

        List<Dish> dishes = dishRepository.findAllById(menuDTO.getDishIds());

        Menu menu = new Menu();
        menu.setName(menuDTO.getName());
        menu.setDescription(menuDTO.getDescription());
        menu.setRestaurant(restaurant);
        menu.setDishes(dishes);

        menuRepository.save(menu);
    }


    public void removeMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public Menu findMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu editMenu(Long id, Menu menu){
        return menuRepository.findById(id).map(mn -> {
            mn.setDescription(menu.getDescription());
            mn.setName(menu.getName());
            mn.setDishes(menu.getDishes());
            return menuRepository.save(mn);
        }).orElse(null);
    }

    public List<Menu> ListMenus(){
        return menuRepository.findAll();
    }

}
