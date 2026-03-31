package com.vendas.api.mapper;

import com.vendas.api.controllers.request.CategoryRequest;
import com.vendas.api.controllers.response.CategoryResponse;
import com.vendas.api.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryRequest request){
        Category category = new Category();

        category.setName(request.name());
        return category;

    }

    public CategoryResponse toResponse (Category category){

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();


    }

}
