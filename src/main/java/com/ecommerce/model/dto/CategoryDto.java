package com.ecommerce.model.dto;

import com.ecommerce.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    Long id;
    String name;
    Long parent;
    public CategoryDto(Category category) {
        setId(category.getId());
        setName(category.getName());
        if (category.getParent() != null)
            setParent(category.getParent().getId());
    }
}
