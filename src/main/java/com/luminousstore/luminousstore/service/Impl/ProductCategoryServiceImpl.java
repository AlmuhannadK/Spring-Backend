package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.repository.ProductCategoryRepository;
import com.luminousstore.luminousstore.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

}
