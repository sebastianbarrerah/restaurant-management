package com.ApiRestFull.restaurant_management.repositories;

import com.ApiRestFull.restaurant_management.model.OrderReques;
import com.ApiRestFull.restaurant_management.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequesRepository extends JpaRepository<OrderReques, Long> {
}
