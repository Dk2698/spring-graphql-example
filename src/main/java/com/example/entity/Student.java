package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_student")
@Setter
@Getter
public class Student {

    @Id
    private int StudentId;
    private String studentName;
    private String about;

    // one to one relation
    // in this table create foreign key from laptop Id;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL) //not foreign key create for that table,
    private Laptop laptop; // parent child some operations perform


    //many address; // list or set use here
    // mapped mmeand not create foreign for this field
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) // for that field
    private List<Address> addressList = new ArrayList<>(); // create one table and manger one direction
    // but mention to other table many to one  , bidirectional

    // cascade means  student remove  when auto remove address to linked between them

}
