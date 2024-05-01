package com.siddharth.carrentalsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {

    private String name;
    private String licenseNumber;
    private String phone;
    private String email;
}
