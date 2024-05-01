package com.siddharth.carrentalsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;
    private String licenseNumber;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;
}
