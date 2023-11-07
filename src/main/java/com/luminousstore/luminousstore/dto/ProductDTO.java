package com.luminousstore.luminousstore.dto;

import com.luminousstore.luminousstore.entity.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String sku;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private int unitsInStock;

    private ProductCategory category;


}


