package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
