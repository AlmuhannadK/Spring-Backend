package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
