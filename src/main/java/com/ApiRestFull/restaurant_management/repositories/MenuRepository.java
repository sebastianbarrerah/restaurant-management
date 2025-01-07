package com.ApiRestFull.restaurant_management.repositories;

import com.ApiRestFull.restaurant_management.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
