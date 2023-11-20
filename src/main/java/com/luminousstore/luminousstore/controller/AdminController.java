package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.service.Impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminService;


    //          Product Management          //

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return null;
    }
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {

        return "product added to inventory";
    }
    @DeleteMapping("/products/{id}")
    public void removeProduct(@RequestParam("id") Long id) {

    }
    @PutMapping ("/products/{id}")
    public void updateProduct(@RequestParam("id") Long id, @RequestBody Product product) {

    }
    /////////////////////////////////////////////


    //          Order Management          //
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return null;
    }
    //ACCEPT || REJECT ORDERS

    /////////////////////////////////////////////


    //          Customer Management          //
    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllCustomers() {
        return null;
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@RequestParam("id") Long id) {

    }
    /////////////////////////////////////////////

}
