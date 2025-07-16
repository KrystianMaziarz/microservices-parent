package pl.com.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.com.productservice.dto.CategoryRequestDto;
import pl.com.productservice.dto.CategoryResponse;
import pl.com.productservice.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CategoryResponse addNewCategory(CategoryRequestDto categoryRequestDto) {

        return categoryService.addNewCategory(categoryRequestDto);
    }

    @GetMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public List<CategoryResponse> getAllCategories () {

        return categoryService.getAllCategories();
    }

    @GetMapping ("/{id}")
    @ResponseStatus (HttpStatus.FOUND)
    public CategoryResponse getCategory(@PathVariable Long id) {

        return categoryService.getCategory(id);
    }

    @DeleteMapping ({"/{id}"})
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void deleteCategory (@PathVariable Long id) {

        categoryService.deleteCategory(id);
    }
}
