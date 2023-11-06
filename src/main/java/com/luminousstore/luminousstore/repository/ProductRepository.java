package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);

    Product findProductById(Long id);

}
