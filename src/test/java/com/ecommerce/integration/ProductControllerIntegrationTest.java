package com.ecommerce.integration;

import com.ecommerce.controller.ProductController;
import com.ecommerce.model.dto.CategoryDto;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Category;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerIntegrationTest {
    @MockBean
    ProductService productService;

    @MockBean
    CategoryRepository categoryRepository;

    @MockBean
    ProductRepository productRepository;

    @InjectMocks
    ProductController productController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    private static final String URL = "/products";
    private static final Category categoryMock = new Category();
    private static final CategoryDto categoryDtoMock = new CategoryDto();
    private static final ProductDto productDtoMock = new ProductDto();
    private static final Long idMock = 1L;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void givenNoProductExistsWhenGetProductsIsCalledThenGetHttpNoContent() throws Exception {
        productRepository.deleteAll();
        this.mockMvc.perform(get(URL)).andExpect(status().isNoContent());
    }

    @Test
    public void given1ProductExistsWhenGetProductsIsCalledThenGetHttpOk() throws Exception {
        given(this.productService.getAllProducts()).willReturn(Arrays.asList(productDtoMock));
        this.mockMvc.perform(get(URL)).andExpect(status().isOk());
    }
}
