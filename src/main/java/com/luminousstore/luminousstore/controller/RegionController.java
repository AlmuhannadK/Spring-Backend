package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Region;
import com.luminousstore.luminousstore.service.Impl.RegionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionServiceImpl regionService;


    @GetMapping("/{code}")
    public ResponseEntity<List<Region>> getRegionByCountryCode(@RequestParam("code") String code) {
        return ResponseEntity.ok(this.regionService.getRegionByCountryCode(code));
    }

}
