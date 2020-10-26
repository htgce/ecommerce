package com.ecommerce.service;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void given1ProductExistsInDbWhenAllProductsAreRequestedThenGet1Product() {
        List<Product> productListMock = new ArrayList<>();
        productListMock.add(new Product());
        when(productRepository.findAll()).thenReturn(productListMock);
        List<ProductDto> allProducts = productService.getAllProducts();
        assertEquals(1, allProducts.size());
    }

    @Test
    public void givenProductDtoWhenProductIsRequestedToSaveThenResultHasAnId() {
        ProductDto productDto = new ProductDto();
        Product productMock = new Product();
        Long id = 1L;
        productMock.setId(id);
        when(productRepository.save(any(Product.class))).thenReturn(productMock);
        ProductDto result = productService.addNewProduct(productDto);
        assertEquals(id, result.getId());
    }
}
