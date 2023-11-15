package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.ProductCategory;
import com.luminousstore.luminousstore.service.Impl.ProductCategoryServiceImpl;
import com.luminousstore.luminousstore.service.Impl.ProductServiceImpl;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
@Validated //for PathVar and ReqParam
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductCategoryServiceImpl productCategoryService;


    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") @Min(1) @Max(100) Long id) {
        return ResponseEntity.ok(this.productService.findProductById(id));
    }


    @GetMapping("/products/search/{name}")
    public ResponseEntity<Page<Product>> findByNameContaining(@RequestParam("name") @NotBlank @Size(min = 1, max = 30) String name, Pageable pageable) {
        return ResponseEntity.ok(this.productService.findByNameContaining(name, pageable));
    }


// products paginated by category
    @GetMapping("/products/search/category/{id}")
    public ResponseEntity<Page<Product>> getByCategory(@RequestParam("id") @Min(1) Long id, Pageable pageable) {
        return ResponseEntity.ok(this.productService.findByCategoryId(id, pageable));
    }

    @GetMapping(path = "/product-category")
    public ResponseEntity<List<ProductCategory>> getProductCategory() {
        return ResponseEntity.ok(this.productCategoryService.getProductCategories());
    }

}
