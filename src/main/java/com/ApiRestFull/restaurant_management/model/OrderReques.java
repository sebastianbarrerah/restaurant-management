package com.ApiRestFull.restaurant_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderReques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Integer total;
    @JoinColumn(name = "user_id")
    private Users user;
    @OneToOne( mappedBy = "orderRequest")
    private OrderDetails orderDetails;

    public OrderReques() {}

    public OrderReques(Long id, String date, Integer total, Users user, OrderDetails orderDetails) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.user = user;
        this.orderDetails = orderDetails;
    }


}
