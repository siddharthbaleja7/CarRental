package com.siddharth.carrentalsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Entity(name = "rental")
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    private int vehicleId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date startDate;
    private Date endDate;
    private double totalCost;

    // Constructors, getters, setters
}