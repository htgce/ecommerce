package com.trendyol.ecommerce.controller;

import com.trendyol.ecommerce.model.dto.CategoryDto;
import com.trendyol.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getCategoryList();
    }
}
