package com.tybootcamp.ecomm.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "basket_entry")
@NoArgsConstructor
public class BasketEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

    public BasketEntry(Long customerId, Long productId){
        this.customerId = customerId;
        this.productId = productId;
    }
}
