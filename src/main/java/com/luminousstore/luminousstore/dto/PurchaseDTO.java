package com.luminousstore.luminousstore.dto;

import com.luminousstore.luminousstore.entity.Address;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.OrderItem;
import com.luminousstore.luminousstore.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseDTO {

    private User user;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private List<OrderItem> orderItems;
}

