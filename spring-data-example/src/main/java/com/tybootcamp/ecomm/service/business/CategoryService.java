package com.tybootcamp.ecomm.service.business;

import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.service.data.CategoryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public CategoryDataService categoryDataService;

    public List<Category> findByIds(List<Long> categoryIds){
        return categoryDataService.findByIdIn(categoryIds);
    }
}
