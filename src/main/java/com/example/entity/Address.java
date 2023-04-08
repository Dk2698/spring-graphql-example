package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_address")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    private int addressId;

    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id") // field name create
    private Student student ;

}
