package com.trendyol.ecommerce.services;

import com.trendyol.ecommerce.model.dto.ProductDto;
import com.trendyol.ecommerce.model.entity.Product;
import com.trendyol.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addNewProduct(ProductDto productDto) {
        productRepository.save(new Product(productDto));
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
