package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
