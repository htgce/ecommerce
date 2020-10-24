package com.trendyol.ecommerce.repository;

import com.trendyol.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
