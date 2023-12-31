package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findByCountryCode(String code);
}
