package com.ApiRestFull.restaurant_management.services;


import com.ApiRestFull.restaurant_management.model.OrderReques;
import com.ApiRestFull.restaurant_management.repositories.OrderDetailRepository;
import com.ApiRestFull.restaurant_management.repositories.OrderRequesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRequesService {

    private final OrderRequesRepository orderRequestRepository;
    private final OrderDetailRepository orderDetailRepository;


    @Autowired
    public OrderRequesService(OrderRequesRepository orderRequestRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRequestRepository = orderRequestRepository;
        this.orderDetailRepository = orderDetailRepository;
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
