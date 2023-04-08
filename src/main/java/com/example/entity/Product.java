package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    private  String pId;
    private String productName;

    @ManyToMany(mappedBy = "products")
    private List<Category> categoryList = new ArrayList<>();
    // create two table for manage
    // used mapping by means no create that table ->  one way to used
}
