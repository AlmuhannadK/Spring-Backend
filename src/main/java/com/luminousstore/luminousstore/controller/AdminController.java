package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.ProductDTO;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.service.Impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
//@Validated
public class AdminController {

    private final AdminServiceImpl adminService;


    //          Product Management          //
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(this.adminService.getAllProducts());
    }
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(this.adminService.addProduct(product));
    }
    @DeleteMapping("/products/{id}")
    public void removeProduct(@RequestParam("id") Long id) {
        this.adminService.deleteProduct(id);
    }
    @PutMapping ("/products/{id}")
    public void updateProduct(@RequestParam("id") Long id, @RequestBody ProductDTO productDTO) {
        this.adminService.updateProduct(id, productDTO);
    }
    /////////////////////////////////////////////

    //          Customer Management          //
    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllCustomers() {
        return ResponseEntity.ok(this.adminService.getAllCustomers());
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@RequestParam("id") Long id) {

        this.adminService.deleteCustomer(id);
    }
    /////////////////////////////////////////////


    //          Order Management          //
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(this.adminService.getAllOrders());
    }
    //ACCEPT || REJECT ORDERS
    @PostMapping("/orders/status")
    public ResponseEntity<Optional<Order>> changeOrderStatus(@RequestParam("id") Long id,
                                                             @RequestParam("status") String status) {
        return ResponseEntity.ok(this.adminService.changeOrderStatus(id, status));
    }

}
