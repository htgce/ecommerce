package com.ecommerce.services;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDto addNewProduct(ProductDto productDto) {
        return new ProductDto(productRepository.save(new Product(productDto)));
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
