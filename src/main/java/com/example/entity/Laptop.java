package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jpa_laptops")
@Setter
@Getter
public class Laptop {
    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    // Bidirectional means // both table inside create foreign key
    @OneToOne
    @JoinColumn(name = "student_id")
    private  Student student; // default name student_student_Id
}
