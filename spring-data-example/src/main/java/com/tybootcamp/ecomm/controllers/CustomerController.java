package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.service.business.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    public CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name="customerId") Long customerId){
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
}
