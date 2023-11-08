package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Country;
import com.luminousstore.luminousstore.service.Impl.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryServiceImpl countryService;

    @GetMapping()
    public List<Country> getAllCountries() {
        return this.countryService.getAllCountries();
    }
}
