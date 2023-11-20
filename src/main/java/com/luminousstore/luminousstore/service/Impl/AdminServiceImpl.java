package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.repository.OrderRepository;
import com.luminousstore.luminousstore.repository.ProductRepository;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    ////////    PRODUCT MANAGEMENT    ///////////
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(Product product) { // update is similar
        return this.productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }


    ////////    CUSTOMER MANAGEMENT    ///////////
    public List<User> getAllCustomers() {
        return this.userRepository.findAll();
    }

    public void deleteCustomer(Long id) {
        this.userRepository.deleteById(id);
    }

    ////////    ORDER MANAGEMENT    ///////////

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
    public String acceptOrder(Long id) {
        this.orderRepository.findById(id).get().setStatus("ACCEPTED");

        return "Order is approved and will ship soon";
    }
    public String rejectOrder(Long id) {
        this.orderRepository.findById(id).get().setStatus("REJECTED");

        return "Order is rejected by admin";
    }



}
