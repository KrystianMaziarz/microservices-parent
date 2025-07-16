package pl.com.productservice.mapper;

import org.mapstruct.Mapper;
import pl.com.productservice.dto.CategoryRequestDto;
import pl.com.productservice.dto.CategoryResponse;
import pl.com.productservice.model.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity mapCategoryRequestToCategoryEntity(CategoryRequestDto categoryRequestDto);

    CategoryResponse mapCategoryEntityToResponseDto(CategoryEntity categoryEntity);

}
