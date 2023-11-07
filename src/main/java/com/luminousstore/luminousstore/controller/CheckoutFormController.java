package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.service.Impl.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CheckoutFormController {

    private final CountryServiceImpl countryService;
}
