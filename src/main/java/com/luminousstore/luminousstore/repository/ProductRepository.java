package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Page<Product> findByNameContaining(String name, Pageable pageable);
    Product findProductById(Long id);

    Page<Product> findByCategoryId(Long id, Pageable pageable);

}
