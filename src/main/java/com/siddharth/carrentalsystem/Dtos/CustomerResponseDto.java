package com.siddharth.carrentalsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDto {
    private int CustomerID;
    private String name;
    private String licenseNumber;
    private String phone;
    private String email;
}
