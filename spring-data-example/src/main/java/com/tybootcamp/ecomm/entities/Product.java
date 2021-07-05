package com.tybootcamp.ecomm.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products",indexes = @Index(columnList = "name"))
@Getter
@Setter
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String name2;
    private String description;
    @NotNull
    private float price;

    @ElementCollection
    @CollectionTable(name = "Product_Images", joinColumns = @JoinColumn(name = "product_id", nullable = false))
    @Column(name = "image_URL", nullable = false)
    @Size(min = 1)
    @NotNull
    private List<String> images;

    @ManyToOne(targetEntity = Seller.class)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Seller seller;


    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @Size(min = 1)
    @NotNull
    private Set<Category> fallIntoCategories;

    public Product(String name2, String name, String description, float price, List<String> images, Seller seller, HashSet<Category> fallIntoCategories)
    {
        this.name = name;
        this.name2 = name2;
        this.description = description;
        this.price = price;
        this.images = images;
        this.seller = seller;
        this.fallIntoCategories = fallIntoCategories;
    }
}

