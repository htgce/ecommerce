package com.trendyol.ecommerce.model.entity;

import com.trendyol.ecommerce.model.dto.CategoryDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category extends ECommerceObject {
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> productList;

    public Category(CategoryDto categoryDto) {
        setId(categoryDto.getId());
        setName(categoryDto.getName());
    }
}
