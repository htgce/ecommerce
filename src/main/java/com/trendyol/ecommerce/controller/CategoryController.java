package com.trendyol.ecommerce.controller;

import com.trendyol.ecommerce.model.dto.CategoryDto;
import com.trendyol.ecommerce.model.dto.ProductDto;
import com.trendyol.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDto>> getProductListByCategory(@PathVariable String categoryId) {
        List<ProductDto> productList = categoryService.getProductList(Long.parseLong(categoryId));
        if (productList != null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
