package com.ecommerce.controller;

import com.ecommerce.model.dto.CategoryDto;
import com.ecommerce.model.entity.Category;
import com.ecommerce.services.CategoryService;
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
public class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    public void givenNoCategoryExistsInDbWhenAllCategoriesAreRequestedThenGetNoContent() {
        when(categoryService.getCategoryList()).thenReturn(Arrays.asList());
        ResponseEntity<List<CategoryDto>> actual = categoryController.getAllCategories();
        assertEquals(null, actual.getBody());
        assertEquals(HttpStatus.NO_CONTENT, actual.getStatusCode());
    }

    @Test
    public void given1CategoryExistsInDbWhenAllCategoriesAreRequestedThenGet1Category() {
        List<CategoryDto> categoryListMock = new ArrayList<>();
        categoryListMock.add(new CategoryDto());
        when(categoryService.getCategoryList()).thenReturn(categoryListMock);
        ResponseEntity<List<CategoryDto>> actual = categoryController.getAllCategories();
        assertEquals(1, actual.getBody().size());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void givenCategoryDtoWhenCategoryIsRequestedToSaveThenResultHasAnId() {
        CategoryDto categoryDtoMock = new CategoryDto();
        Category categoryMock = new Category();
        categoryMock.setName("categoryMock");
        Long id = 1L;
        categoryDtoMock.setId(id);
        when(categoryService.addCategory(any(CategoryDto.class))).thenReturn(categoryDtoMock);
        ResponseEntity<CategoryDto> actual = categoryController.saveCategory(categoryDtoMock);
        assertEquals(id, actual.getBody().getId());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}
