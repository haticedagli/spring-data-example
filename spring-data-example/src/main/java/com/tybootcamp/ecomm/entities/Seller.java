package com.tybootcamp.ecomm.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class Seller
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String accountId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seller", orphanRemoval = true)
    private Profile profile;

    public Seller(String accountId)
    {
        this.accountId = accountId;
    }

    @Override
    public String toString()
    {
        if (profile == null)
        {
            return super.toString();
        }
        else
        {
            return getProfile().getFirstName() + " " + getProfile().getLastName();
        }
    }
}

