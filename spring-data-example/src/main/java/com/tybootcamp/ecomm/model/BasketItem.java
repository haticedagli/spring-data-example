package com.tybootcamp.ecomm.model;

import com.tybootcamp.ecomm.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasketItem {
    public Long id;
    public Product product;
}
