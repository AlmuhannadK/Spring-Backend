package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.entity.ProductCategory;
import com.luminousstore.luminousstore.repository.ProductCategoryRepository;
import com.luminousstore.luminousstore.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getProductCategories() {
        return this.productCategoryRepository.findAll();
    }

}