package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.Menu;
import com.ApiRestFull.restaurant_management.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menu) {
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
