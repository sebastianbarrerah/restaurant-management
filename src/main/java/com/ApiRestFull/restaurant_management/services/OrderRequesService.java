package com.ApiRestFull.restaurant_management.services;


import com.ApiRestFull.restaurant_management.model.OrderReques;
import com.ApiRestFull.restaurant_management.repositories.OrderRequesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRequesService {

    private final OrderRequesRepository orderRequestRepository;

    public OrderRequesService(OrderRequesRepository orderRequestRepository) {
        this.orderRequestRepository = orderRequestRepository;
    }

    public OrderReques addOrder(OrderReques orderRequest) {
        return orderRequestRepository.save(orderRequest);
    }

    public List<OrderReques> listarOrdenes() {
        return orderRequestRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRequestRepository.deleteById(id);
    }
}
