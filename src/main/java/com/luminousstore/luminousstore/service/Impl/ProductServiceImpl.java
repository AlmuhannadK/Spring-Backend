package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.repository.ProductRepository;
import com.luminousstore.luminousstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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

//    public Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable) {
//        return this.productRepository.findByCategoryId(id, pageable);
//    }


    public Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable) {
        return this.productRepository.findByCategoryId(id, pageable);
    }


    public Page<Product> getProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}
