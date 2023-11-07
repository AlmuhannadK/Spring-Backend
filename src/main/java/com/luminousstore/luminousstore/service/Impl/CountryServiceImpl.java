package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.Country;
import com.luminousstore.luminousstore.repository.CountryRepository;
import com.luminousstore.luminousstore.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return this.countryRepository.findAll();
    }

}
