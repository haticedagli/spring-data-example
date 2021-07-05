package com.tybootcamp.ecomm.service.data;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDataService {

    public CustomerRepository customerRepository;

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public boolean isExistById(Long id){
        if(id == null) return false;
        return customerRepository.existsById(id);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
