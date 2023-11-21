package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.ProductDTO;
import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.mapper.Impl.ProductMapperImpl;
import com.luminousstore.luminousstore.mapper.Impl.UserMapperImpl;
import com.luminousstore.luminousstore.repository.OrderRepository;
import com.luminousstore.luminousstore.repository.ProductRepository;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private final ProductMapperImpl productMapper;


    ////////    PRODUCT MANAGEMENT    ///////////
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(ProductDTO productDTO) { // update is similar

        Product product = this.productMapper.transformToEntity(productDTO);
        this.productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {

        Product product = this.productRepository.findProductById(id);

        product.setSku(productDTO.getSku());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setUnitsInStock(productDTO.getUnitsInStock());
        product.setCategory(productDTO.getCategory());

        return this.productRepository.save(product);
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

    public Optional<Order> changeOrderStatus(Long id, String status) {

        Optional<Order> order = this.orderRepository.findById(id);
        // if present, change status of object then save it in db.
        if(order.isPresent()) {
            order.get().setStatus(status);
            this.orderRepository.save(order.get());
        } else {
            return null;
        }
        return order;
    }
}
