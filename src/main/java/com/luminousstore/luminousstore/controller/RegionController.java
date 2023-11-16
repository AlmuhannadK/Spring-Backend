package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.entity.Region;
import com.luminousstore.luminousstore.service.Impl.RegionServiceImpl;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/")
@Validated
public class RegionController {

    private final RegionServiceImpl regionService;


    @GetMapping("/{code}")
    public ResponseEntity<List<Region>> getRegionByCountryCode(@RequestParam("code") @NotBlank @Size(min = 2, max = 2) String code) {
        return ResponseEntity.ok(this.regionService.getRegionByCountryCode(code));
    }

}
