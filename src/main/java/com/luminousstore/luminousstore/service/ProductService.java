package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {


    Product findProductById(Long id);

//    List<Product> findByNameContaining(String name);

    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);


    List<Product> getAllProducts();

    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

}
