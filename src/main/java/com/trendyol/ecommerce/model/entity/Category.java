package com.trendyol.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> childCategoryList;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> productList;
}
