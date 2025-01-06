package com.ApiRestFull.restaurant_management.repositories;

import com.ApiRestFull.restaurant_management.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {
}
