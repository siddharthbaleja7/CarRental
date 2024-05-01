package com.siddharth.carrentalsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "branch")
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId; // This property maps to the 'BranchId' column

    private String location;
    private int managerId;
    private String contactDetails;

    // Constructors, getters, setters
}