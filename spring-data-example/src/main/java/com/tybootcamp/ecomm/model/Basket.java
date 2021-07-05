package com.tybootcamp.ecomm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Basket {
    List<BasketItem> basketItems = new ArrayList<>();
}
