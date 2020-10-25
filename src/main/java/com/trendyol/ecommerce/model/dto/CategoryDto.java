package com.trendyol.ecommerce.model.dto;

import com.trendyol.ecommerce.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    Long id;
    String name;
    Long parent;
    List<ProductDto> productList;

    public CategoryDto(Category category) {
        setId(category.getId());
        setName(category.getName());
        if (category.getParent() != null)
            setParent(category.getParent().getId());
    }
}
