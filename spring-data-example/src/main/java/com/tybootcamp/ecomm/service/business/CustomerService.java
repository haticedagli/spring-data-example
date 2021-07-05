package com.tybootcamp.ecomm.service.business;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.service.data.CustomerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public CustomerDataService customerDataService;

    public Customer getCustomer(Long id){
        return customerDataService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Customer> getCustomers(){
        return customerDataService.findAll();
    }

    public boolean isCustomerExist(Long id){
        return customerDataService.isExistById(id);
    }
}
