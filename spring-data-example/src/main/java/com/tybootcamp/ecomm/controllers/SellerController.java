package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.service.business.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/seller")
@RequiredArgsConstructor
public class SellerController {

    public SellerService sellerService;

    @GetMapping(path = "/")
    public ResponseEntity<?> getSellerById(@RequestParam(value = "id") long id)
    {
        try {
            Seller seller = sellerService.getSellerById(id);
            log.info("The seller with id {} = {}", id, seller.toString());
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("There isn't any seller with this name.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Seller> addNewSeller(@Valid @RequestBody Seller seller)
    {
        Seller sellerEntity = sellerService.saveSeller(seller);
        return new ResponseEntity<>(sellerEntity, HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<?> updateSeller(@Valid @RequestBody Seller seller)
    {
        try{
            Seller updatedSeller = sellerService.updateSeller(seller);
            log.info("The row of {} updated.", updatedSeller.toString());
            return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>("This seller doesn't exists.", HttpStatus.NOT_FOUND);
        }
    }
}
