package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.model.Basket;
import com.tybootcamp.ecomm.model.BasketItem;
import com.tybootcamp.ecomm.service.business.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/basket")
public class BasketController {

    public BasketService basketService;

    @PostMapping("/{customerId}/{productId}")
    public ResponseEntity<BasketItem> addToBasket(@PathVariable(name="customerId") Long customerId, @PathVariable(name="productId") Long productId) {
        return new ResponseEntity<>(basketService.addProductToBasket(customerId, productId), HttpStatus.OK);
    }

    @DeleteMapping("/{basketItemId}")
    public ResponseEntity<String> removeFromBasket(@PathVariable(name="basketItemId") Long basketItemId) {
        basketService.removeProductFromBasket(basketItemId);
        return new ResponseEntity<>("Item removed successfully.", HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Basket> getBasket(@PathVariable(name="customerId") Long customerId) {
        return new ResponseEntity<>(basketService.getBasket(customerId), HttpStatus.OK);
    }
}
