package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.OrderDetails;
import com.ApiRestFull.restaurant_management.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public Optional<OrderDetails> findOrderDetailById(Long id) {
        return orderDetailRepository.findById(id);
    }

    public List<OrderDetails> listOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetails updateOrderDetail(long id, OrderDetails orderDetail) {
        return orderDetailRepository.findById(id).map(orderDetails -> {
            orderDetails.setQuantity(orderDetail.getQuantity());
            orderDetails.setOrderReques(orderDetail.getOrderReques());
            orderDetails.setDish(orderDetail.getDish());
            return orderDetailRepository.save(orderDetails);
        }).orElse(null);
    }
}
