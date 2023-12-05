package com.luminousstore.luminousstore.dto;

import com.luminousstore.luminousstore.entity.Address;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.OrderItem;
import com.luminousstore.luminousstore.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Builder
//@Validated
public class PurchaseRequest {

    private User customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private List<OrderItem> orderItems;

}

