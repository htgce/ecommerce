package com.ecommerce.controller;

import com.ecommerce.model.dto.CategoryDto;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    @Operation(description = "Retrieve categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getCategoryList();
        if (categoryList != null && !categoryList.isEmpty()) {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("")
    @Operation(description = "Save category")
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/products")
    @Operation(description = "Retrieve products of category by {categoryId}")
    public ResponseEntity<List<ProductDto>> getProductListByCategory(@PathVariable String categoryId) {
        List<ProductDto> productList = categoryService.getProductList(Long.parseLong(categoryId));
        if (productList != null && !productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
