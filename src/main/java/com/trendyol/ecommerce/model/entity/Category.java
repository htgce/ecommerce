package com.trendyol.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category extends ECommerceObject {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> childCategoryList;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> productList;
}
