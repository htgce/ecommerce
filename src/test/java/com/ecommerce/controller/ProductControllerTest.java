package com.ecommerce.controller;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Product;
import com.ecommerce.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void givenNoProductExistsInDbWhenAllProductsAreRequestedThenGetNoContent() {
        when(productService.getAllProducts()).thenReturn(Arrays.asList());
        ResponseEntity<List<ProductDto>> actual = productController.getAllProducts();
        assertEquals(null, actual.getBody());
        assertEquals(HttpStatus.NO_CONTENT, actual.getStatusCode());
    }

    @Test
    public void given1ProductExistsInDbWhenAllProductsAreRequestedThenGet1Product() {
        List<ProductDto> productDtoListMock = new ArrayList<>();
        productDtoListMock.add(new ProductDto());
        when(productService.getAllProducts()).thenReturn(productDtoListMock);
        ResponseEntity<List<ProductDto>> actual = productController.getAllProducts();
        assertEquals(1, actual.getBody().size());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void givenProductDtoWhenProductIsRequestedToSaveThenResultHasAnId() {
        ProductDto productDtoMock = new ProductDto();
        Product productMock = new Product();
        productDtoMock.setDescription("categoryMock");
        Long id = 1L;
        productDtoMock.setId(id);
        when(productService.addNewProduct(any(ProductDto.class))).thenReturn(productDtoMock);
        ResponseEntity<ProductDto> actual = productController.saveProduct(productDtoMock);
        assertEquals(id, actual.getBody().getId());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}
