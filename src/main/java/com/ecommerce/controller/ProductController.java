package com.ecommerce.controller;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    @Operation(description = "Retrieve products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productList = productService.getAllProducts();
        if (productList != null && !productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("")
    @Operation(description = "Save product")
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.addNewProduct(productDto), HttpStatus.OK);
    }
}
