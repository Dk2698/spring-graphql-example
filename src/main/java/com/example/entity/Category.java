package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    private  String cId;
    private String title;


//    @ManyToMany(mappedBy = "categoryList", cascade = CascadeType.ALL)
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Product> products = new ArrayList<>();
}
