package com.tybootcamp.ecomm.service.business;

import com.tybootcamp.ecomm.entities.BasketEntry;
import com.tybootcamp.ecomm.entities.Product;
import com.tybootcamp.ecomm.model.Basket;
import com.tybootcamp.ecomm.model.BasketItem;
import com.tybootcamp.ecomm.service.data.BasketEntryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketService {

    public CustomerService customerService;
    public ProductService productService;
    public BasketEntryDataService basketEntryDataService;

    public BasketItem addProductToBasket(Long customerId, Long productId){
        if(!customerService.isCustomerExist(customerId)){
            throw new EntityNotFoundException("Customer not found.");
        }
        if(!productService.isProductExist(productId)){
            throw new EntityNotFoundException("Product not found.");
        }
        BasketEntry basketEntry = basketEntryDataService.save(new BasketEntry(customerId, productId));
        return new BasketItem(basketEntry.getId(), productService.getProductById(basketEntry.getProductId()));
    }

    public void removeProductFromBasket(Long basketEntryId){
        basketEntryDataService.remove(basketEntryId);
    }

    public Basket getBasket(Long customerId){
        if(!customerService.isCustomerExist(customerId)){
            throw new EntityNotFoundException("Customer not found.");
        }
        List<BasketEntry> basketEntries = basketEntryDataService.getByCustomerId(customerId);
        List<Long> productIds = basketEntries.stream().map(BasketEntry::getProductId).collect(Collectors.toList());
        List<Product> products = productService.getProductsByIds(productIds);
        Basket basket = new Basket();
        List<BasketItem> basketItems = new ArrayList<>();
        for(BasketEntry basketEntry : basketEntries){
            basketItems.add(new BasketItem(basketEntry.getId(), products.stream()
                    .filter(k-> k.getId().equals(basketEntry.getProductId()))
                    .findFirst()
                    .orElseThrow(EntityNotFoundException::new)));
        }
        basket.setBasketItems(basketItems);
        return basket;
    }
}
