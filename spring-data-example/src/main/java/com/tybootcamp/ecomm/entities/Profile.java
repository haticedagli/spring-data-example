package com.tybootcamp.ecomm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tybootcamp.ecomm.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile
{
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(nullable = false)
    @MapsId
    @JsonIgnore
    private Seller seller;


    @OneToOne
    @JoinColumn(nullable = false)
    @MapsId
    @JsonIgnore
    private Customer customer;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String website;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String address;

    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Profile(Seller seller, String firstName, String lastName, Gender gender)
    {
        this.seller = seller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
