package com.trendyol.ecommerce.services;

import com.trendyol.ecommerce.model.dto.CategoryDto;
import com.trendyol.ecommerce.model.dto.ProductDto;
import com.trendyol.ecommerce.model.entity.Category;
import com.trendyol.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDto> getCategoryList() {
        return categoryRepository.findAll().stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    public void addCategory(CategoryDto categoryDto) {
        Category savedCategory = categoryRepository.save(new Category(categoryDto));
    }

    public List<ProductDto> getProductList(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getProductList().stream().map(ProductDto::new).collect(Collectors.toList());
        } else return null;
    }
}

