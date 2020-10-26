package com.ecommerce.model.dto;

import com.ecommerce.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String description;
    private String brandName;
    private String size;
    private String age;
    private BigDecimal price;
    private CategoryDto categoryDto;

    public ProductDto(Product product) {
        setId(product.getId());
        setDescription(product.getDescription());
        setAge(product.getAge());
        setSize(product.getSize());
        setPrice(product.getPrice());
        if (product.getCategory() != null)
            setCategoryDto(new CategoryDto(product.getCategory()));
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", brandName='" + brandName + '\'' +
                ", size='" + size + '\'' +
                ", age='" + age + '\'' +
                ", price=" + price +
                ", categoryDto=" + categoryDto.getName() +
                '}';
    }
}

