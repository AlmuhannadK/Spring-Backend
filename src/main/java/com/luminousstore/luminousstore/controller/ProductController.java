package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;


    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.productService.findProductById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Product>> findByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(this.productService.findByNameContaining(name));
    }



}
