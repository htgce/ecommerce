package com.trendyol.ecommerce.controller;

import com.trendyol.ecommerce.model.dto.ProductDto;
import com.trendyol.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
