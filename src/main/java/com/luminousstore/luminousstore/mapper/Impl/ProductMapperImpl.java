package com.luminousstore.luminousstore.mapper.Impl;

import com.luminousstore.luminousstore.dto.ProductDTO;
import com.luminousstore.luminousstore.entity.Product;
import com.luminousstore.luminousstore.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper {


    @Override
    public Product transformToEntity(ProductDTO productDTO) {
        return Product.builder()
                .sku(productDTO.getSku())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .unitPrice(productDTO.getUnitPrice())
                .imageUrl(productDTO.getImageUrl())
                .unitsInStock(productDTO.getUnitsInStock())
                .category(productDTO.getCategory())
                .build();
    }

    @Override
    public ProductDTO tranformToDto(Product product) {
        return ProductDTO.builder()
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .imageUrl(product.getImageUrl())
                .unitsInStock(product.getUnitsInStock())
                .category(product.getCategory())
                .build();
    }
}
