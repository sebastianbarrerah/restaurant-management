package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.OrderDetails;
import com.ApiRestFull.restaurant_management.services.OrderDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/details")
public class OrderDetailController {

    private final OrderDetailService service;

    public OrderDetailController(OrderDetailService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetails>> listOrderDetails() {
        return ResponseEntity.ok(service.listOrderDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailById(@PathVariable Long id) {
        return service.findOrderDetailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetails orderDetail) {
        return ResponseEntity.ok(service.updateOrderDetail(id, orderDetail));
    }

}
