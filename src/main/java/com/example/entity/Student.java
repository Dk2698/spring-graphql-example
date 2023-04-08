package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
