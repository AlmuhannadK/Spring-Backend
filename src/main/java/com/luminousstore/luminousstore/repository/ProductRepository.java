package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);

    Product findProductById(Long id);


    // there's a couple of functions in Angular that use pages and pages sizes as path variables
    //so, I need to use the method headers in the bottom to emulate their behaviour
    // These methods need to be declared in this Product Repository since they use the baseUrl (/products)

//    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
//
//    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
//
//    Page<Product> findByNameContaining(@Param("name") String name, Pageable page);

}
