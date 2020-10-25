package com.trendyol.ecommerce.model.entity;

import com.trendyol.ecommerce.model.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends ECommerceObject {

    @Column
    private String description;

    @Column(name = "BRANDNAME")
    private String brandName;

    @Column
    private String size;

    @Column
    private String age;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
/*    @Transient
    private List<Image> imageList;*/

    /*    @Transient
    private List<Image> commentList;*/

    public Product(ProductDto productDto) {
        setId(productDto.getId());
        setAge(productDto.getAge());
        setBrandName(productDto.getBrandName());
        if (productDto.getCategoryDto() != null)
            setCategory(new Category(productDto.getCategoryDto()));
        setDescription(productDto.getDescription());
        setPrice(productDto.getPrice());
        setSize(productDto.getSize());
    }
}
