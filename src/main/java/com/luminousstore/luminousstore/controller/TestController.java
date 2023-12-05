package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Address;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.OrderItem;
import com.luminousstore.luminousstore.repository.AddressRepository;
import com.luminousstore.luminousstore.repository.OrderItemRepository;
import com.luminousstore.luminousstore.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final OrderItemRepository orderItemRepository;

    @GetMapping("/address")
    public List<Address> getAllAddresses() {
        return this.addressRepository.findAll();
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @GetMapping("/order-items")
    public List<OrderItem> getAllOrderItems() {
        return this.orderItemRepository.findAll();
    }

}
