package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToOne
    private OrderReques orderReques;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public OrderDetails() {}

    public OrderDetails( Integer quantity, OrderReques orderRequest) {
        this.quantity = quantity;
        this.orderReques = orderRequest;

    }
}
