package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
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

//    @GetMapping("/search/{id}")
//    public ResponseEntity<Page<Product>> findByCategoryId(@RequestParam("id") Long id, Pageable pageable) {
//        return ResponseEntity.ok(this.productService.findByCategoryId(id, pageable));
//    }


    @GetMapping("/pageable")
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        return ResponseEntity.ok(this.productService.getProductsPaginated(pageable));
    }


    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = productService.getProductsPaginated(pageable);
        return ResponseEntity.ok(products);
    }



}
