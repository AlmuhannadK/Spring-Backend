package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.entity.Country;
import com.luminousstore.luminousstore.entity.Region;

import java.util.List;

public interface RegionService {

    List<Region> getRegionByCountryCode(String code);

}
