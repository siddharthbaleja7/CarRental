package com.siddharth.carrentalsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequestDto {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private double currentMileage;

}
