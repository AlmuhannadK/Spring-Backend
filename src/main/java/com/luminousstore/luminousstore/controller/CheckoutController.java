package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.PurchaseRequest;
import com.luminousstore.luminousstore.dto.PurchaseResponse;
import com.luminousstore.luminousstore.service.Impl.CheckoutServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/checkout")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutServiceImpl checkoutService;


    @PostMapping(path = "/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody PurchaseRequest purchase) {
        return ResponseEntity.ok(this.checkoutService.placeOrder(purchase));
    }

}
