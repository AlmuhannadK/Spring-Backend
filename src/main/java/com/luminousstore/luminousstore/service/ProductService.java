package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findProductById(Long id);

    List<Product> findByNameContaining(String name);
}
