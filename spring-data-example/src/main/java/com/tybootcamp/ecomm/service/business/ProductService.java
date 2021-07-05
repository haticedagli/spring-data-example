package com.tybootcamp.ecomm.service.business;

import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.entities.Product;
import com.tybootcamp.ecomm.service.data.ProductDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    public ProductDataService productDataService;
    public SellerService sellerService;
    public CategoryService categoryService;

    public List<Product> getProducts(){
        return productDataService.findAll();
    }

    public Product getProductById(Long productId){
        return productDataService.findById(productId).orElseThrow(EntityNotFoundException::new);
    }

    public Product addNewProduct(Product product) throws Exception {
        product.setId(null);
        checkNewProductIsValid(product);
        return productDataService.save(product);
    }

    public Product updateProduct(Product product) throws Exception {
        checkExistProductIsValid(product);
        return productDataService.save(product);
    }

    public List<Product> getProductsByIds(List<Long> productIds){
        return productDataService.findByIdIn(productIds);
    }

    public boolean isProductExist(Long productId){
        return productDataService.isExist(productId);
    }

    private void checkNewProductIsValid(Product product) throws Exception {
        //Check the constraints
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new Exception("Name cannot be empty.");
        }
        if (product.getImages() == null || product.getImages().size() == 0) {
            throw new Exception("Images cannot be empty.");
        }
        if(!sellerService.isSellerExist(product.getSeller().getId())){
            throw new EntityNotFoundException("Seller cannot be empty.");
        }
        List<Long> categoryIds = product.getFallIntoCategories().stream().map(Category::getId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(categoryIds)){
            throw new Exception("Categories cannot be empty");
        }
        List<Category> categories = categoryService.findByIds(categoryIds);
        for(Category category : product.getFallIntoCategories()){
            if(categories.stream().noneMatch(k-> k.getId() == category.getId())){
                throw new EntityNotFoundException("Category not found.");
            }
        }
    }

    private void checkExistProductIsValid(Product product) throws Exception {
        if(!productDataService.isExist(product.getId())){
            throw new EntityNotFoundException("Product not found.");
        }
        if(!sellerService.isSellerExist(product.getSeller().getId())){
            throw new EntityNotFoundException("Seller not found");
        }
        List<Long> categoryIds = product.getFallIntoCategories().stream().map(Category::getId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(categoryIds)){
            throw new Exception("Categories cannot be empty");
        }
        List<Category> categories = categoryService.findByIds(categoryIds);
        for(Category category : product.getFallIntoCategories()){
            if(categories.stream().noneMatch(k-> k.getId() == category.getId())){
                throw new EntityNotFoundException("Category not found.");
            }
        }
    }
}
