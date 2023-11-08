package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.Region;
import com.luminousstore.luminousstore.repository.RegionRepository;
import com.luminousstore.luminousstore.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getRegionByCountryCode(String code) {
        return this.regionRepository.findByCountryCode(code);
    }

}
