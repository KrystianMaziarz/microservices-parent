package pl.com.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.productservice.dto.CategoryRequestDto;
import pl.com.productservice.dto.CategoryResponse;
import pl.com.productservice.exception.CategoryNotFoundException;
import pl.com.productservice.mapper.CategoryMapper;
import pl.com.productservice.model.CategoryEntity;
import pl.com.productservice.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryResponse addNewCategory(CategoryRequestDto categoryRequestDto) {

        CategoryEntity categoryEntity = categoryMapper.mapCategoryRequestToCategoryEntity(categoryRequestDto);

        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);

        return categoryMapper.mapCategoryEntityToResponseDto(savedCategory);
    }

    public List<CategoryResponse> getAllCategories() {

        List<CategoryEntity> categories = categoryRepository.findAll();

        return categories.stream().map(categoryMapper::mapCategoryEntityToResponseDto).toList();
    }

    public CategoryResponse getCategory(Long id) {

        CategoryEntity categoryEntity = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        return categoryMapper.mapCategoryEntityToResponseDto(categoryEntity);
    }

    public void deleteCategory(Long id) {

        CategoryEntity categoryEntity = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        categoryRepository.delete(categoryEntity);
    }
}
