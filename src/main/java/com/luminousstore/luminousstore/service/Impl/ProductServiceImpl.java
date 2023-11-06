package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.repository.ProductRepository;
import com.luminousstore.luminousstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return this.productRepository.findProductById(id);
    }

    public List<Product> findByNameContaining(String name) {
        return this.productRepository.findByNameContaining(name);
    }
}
