package com.trendyol.ecommerce.service;

import com.trendyol.ecommerce.model.dto.CategoryDto;
import com.trendyol.ecommerce.model.entity.Category;
import com.trendyol.ecommerce.repository.CategoryRepository;
import com.trendyol.ecommerce.services.CategoryService;
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
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void given1CategoryExistsInDbWhenAllCategoriesAreRequestedThenGet1Category() {
        List<Category> categoryListMock = new ArrayList<>();
        categoryListMock.add(new Category());
        when(categoryRepository.findAll()).thenReturn(categoryListMock);
        List<CategoryDto> allCategories = categoryService.getCategoryList();
        assertEquals(1, allCategories.size());
    }

    @Test
    public void givenCategoryDtoWhenCategoryIsRequestedToSaveThenResultHasAnId() {
        CategoryDto categoryDtoMock = new CategoryDto();
        Category categoryMock = new Category();
        categoryMock.setName("categoryMock");
        Long id = 1L;
        categoryMock.setId(id);
        when(categoryRepository.save(any(Category.class))).thenReturn(categoryMock);
        CategoryDto result = categoryService.addCategory(categoryDtoMock);
        assertEquals(id, result.getId());
    }
}
