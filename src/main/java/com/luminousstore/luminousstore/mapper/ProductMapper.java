package com.luminousstore.luminousstore.mapper;

import com.luminousstore.luminousstore.dto.ProductDTO;
import com.luminousstore.luminousstore.entity.Product;

public interface ProductMapper {

    Product transformToEntity(ProductDTO productDTO);

    ProductDTO tranformToDto(Product product);
}
