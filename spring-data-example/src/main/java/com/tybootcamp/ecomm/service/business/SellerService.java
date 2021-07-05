package com.tybootcamp.ecomm.service.business;

import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.service.data.SellerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SellerService {

    public SellerDataService sellerDataService;

    public Seller getSellerById(long id){
        return sellerDataService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Seller saveSeller(Seller seller){
        seller.setId(null);
        seller.getProfile().setId(null);
        return sellerDataService.save(seller);
    }

    public Seller updateSeller(Seller seller){
        if(!sellerDataService.isExistById(seller.getId())){
            throw new EntityNotFoundException();
        }
        return sellerDataService.save(seller);
    }

    public boolean isSellerExist(Long id){
        return sellerDataService.isExistById(id);
    }
}
