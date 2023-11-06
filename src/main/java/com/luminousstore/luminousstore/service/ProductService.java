package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findProductById(Long id);

    List<Product> findByNameContaining(String name);

    Page<Product> getProductsPaginated(Pageable pageable);

//    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);




}
