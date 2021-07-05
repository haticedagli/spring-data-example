package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Product;
import com.tybootcamp.ecomm.service.business.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductController {

    public ProductService productService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) throws Exception {
        Product createdProduct = productService.addNewProduct(product);
        log.info("A new Product created with id: {} and name: {}", createdProduct.getId(), createdProduct.getName());
        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) throws Exception {
        Product savedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }
}
