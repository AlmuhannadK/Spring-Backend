package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.PurchaseRequest;
import com.luminousstore.luminousstore.dto.PurchaseResponse;
import com.luminousstore.luminousstore.entity.Order;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.entity.ProductCategory;
import com.luminousstore.luminousstore.repository.OrderRepository;
import com.luminousstore.luminousstore.service.Impl.CheckoutServiceImpl;
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
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Validated //for PathVar and ReqParam
public class test {

   private final OrderRepository orderRepository;

   @GetMapping
    public List<Order> getAllOrders() {
       return this.orderRepository.findAll();
   }
}