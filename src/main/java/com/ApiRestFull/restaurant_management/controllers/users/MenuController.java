package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.Menu;
import com.ApiRestFull.restaurant_management.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/menu")
public class MenuController {

    private final MenuService service;

    @Autowired
    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Menu>> findAllMenus(){
        return ResponseEntity.ok(service.ListMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> findMenuById(@PathVariable Long id){
        return ResponseEntity.ok(service.findMenuById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMenu(@RequestBody Menu menu){
        service.addMenu(menu);
        return ResponseEntity.ok("Menu agreg|ado con exito");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Menu> editMenu(@PathVariable Long id, @RequestBody Menu menu){
        return ResponseEntity.ok(service.editMenu(id, menu));
    }

    @PostMapping("/borrar/{id}")
    public ResponseEntity<String> removeMenu(@PathVariable Long id){
        service.removeMenu(id);
        return ResponseEntity.ok("Menu eliminado con exito");
    }

}
