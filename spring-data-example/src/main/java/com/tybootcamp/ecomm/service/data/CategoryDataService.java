package com.tybootcamp.ecomm.service.data;

import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryDataService {

    public CategoryRepository categoryRepository;

    public List<Category> findByIdIn(List<Long> categoryIds){
        return categoryRepository.findByIdIn(categoryIds);
    }
}
