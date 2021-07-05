package com.tybootcamp.ecomm.service.data;

import com.tybootcamp.ecomm.entities.BasketEntry;
import com.tybootcamp.ecomm.repositories.BasketEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketEntryDataService {

    public BasketEntryRepository basketEntryRepository;

    @Transactional
    public BasketEntry save(BasketEntry basketEntry){
        return basketEntryRepository.save(basketEntry);
    }

    @Transactional
    public void remove(Long id){
        basketEntryRepository.removeById(id);
    }

    public List<BasketEntry> getByCustomerId(Long customerId){
        return basketEntryRepository.findByCustomerId(customerId);
    }
}
