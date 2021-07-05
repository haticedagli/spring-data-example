package com.tybootcamp.ecomm.service.data;

import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerDataService {

    public SellerRepository sellerRepository;

    @Transactional
    public Seller save(Seller seller){
        return sellerRepository.save(seller);
    }

    public Optional<Seller> findById(Long id){
        return sellerRepository.findById(id);
    }

    public boolean isExistById(Long id){
        if(id==null) return false;
        return sellerRepository.existsById(id);
    }

}
