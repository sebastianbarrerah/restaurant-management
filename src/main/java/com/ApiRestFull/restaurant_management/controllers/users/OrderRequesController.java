package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.OrderReques;
import com.ApiRestFull.restaurant_management.services.OrderRequesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderRequesController {

    private final OrderRequesService service;

    public OrderRequesController(OrderRequesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderReques>> listOrder() {
        return ResponseEntity.ok(service.listarOrdenes());
    }

    @PostMapping("/add")
    public ResponseEntity<OrderReques> addOrder(@RequestBody OrderReques orderRequest) {
        return ResponseEntity.ok(service.addOrder(orderRequest));
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.ok("OrderRequest eliminado con éxito");
    }
}
