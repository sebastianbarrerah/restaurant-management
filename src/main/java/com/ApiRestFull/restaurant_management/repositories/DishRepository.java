package com.ApiRestFull.restaurant_management.repositories;

import com.ApiRestFull.restaurant_management.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
