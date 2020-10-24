package com.trendyol.ecommerce.repository;

import com.trendyol.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
