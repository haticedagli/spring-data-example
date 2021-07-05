package com.tybootcamp.ecomm.service.data;

import com.tybootcamp.ecomm.entities.Product;
import com.tybootcamp.ecomm.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDataService {

    public ProductRepository productRepository;

    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public boolean isExist(Long id){
        if(id == null) return false;
        return productRepository.existsById(id);
    }

    public List<Product> findByIdIn(List<Long> ids){
        return productRepository.findByIdIn(ids);
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
}
