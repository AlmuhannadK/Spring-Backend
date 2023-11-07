package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.PurchaseRequest;
import com.luminousstore.luminousstore.dto.PurchaseResponse;
import com.luminousstore.luminousstore.service.Impl.CheckoutServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutServiceImpl checkoutService;


    @PostMapping(path = "/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody PurchaseRequest purchase) {
        return ResponseEntity.ok(this.checkoutService.placeOrder(purchase));
    }

}
