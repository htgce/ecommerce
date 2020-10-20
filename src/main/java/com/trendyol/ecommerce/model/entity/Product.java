package com.trendyol.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    private String brandName;

    private String size;

    private String age;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

/*    @Transient
    private List<Image> imageList;*/

    /*    @Transient
    private List<Image> commentList;*/

}
