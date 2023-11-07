package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.PurchaseRequest;
import com.luminousstore.luminousstore.dto.PurchaseResponse;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.OrderItem;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final UserRepository userRepository;

    @Transactional
    public PurchaseResponse placeOrder(PurchaseRequest purchase) {
        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //fill with order items
        List<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.addOrderItem(item));
        //fill with addresses
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());
        // assign order to customer
        User customer = purchase.getUser();
        customer.addOrder(order);

        this.userRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
            return UUID.randomUUID().toString();
    }
}
