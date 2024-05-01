package com.siddharth.carrentalsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private double currentMileage;
    private String type; // Add 'type' property

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "BranchId")
    private Branch branch;

    // Constructors, getters, setters
}