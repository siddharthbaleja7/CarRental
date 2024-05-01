package com.siddharth.carrentalsystem.Controller;

import com.siddharth.carrentalsystem.Dtos.CustomerRequestDto;
import com.siddharth.carrentalsystem.Dtos.CustomerResponseDto;
import com.siddharth.carrentalsystem.Service.CustomerService;
import com.siddharth.carrentalsystem.Service.VehicleService;
import com.siddharth.carrentalsystem.models.Customer;
import com.siddharth.carrentalsystem.models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    //create
//    @PostMapping("/create")
//    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
//         customerService.createCustomer(customerRequestDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        Customer customer = customerService.createCustomer(customerRequestDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // update
//    @PutMapping("/{customerId}")
//    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") int customerId,@RequestBody  CustomerRequestDto customerRequestDto){
//        customerService.updateCustomer(customerId,customerRequestDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerRequestDto customerRequestDto) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerRequestDto);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    //delete
//    @DeleteMapping("/{customerId}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") int customerId){
//        customerService.deleteCustomer(customerId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int customerId) {
        Customer deletedCustomer = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.NO_CONTENT);
    }

    //read
//    @GetMapping("/{customerId}")
//    public ResponseEntity<CustomerResponseDto> getCustomerbyId(@PathVariable("customerId") int customerId){
//
//        CustomerResponseDto getCustomer = customerService.getCustomerbyId(customerId);
//        return ResponseEntity.ok(getCustomer);
//
//    }
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    //update contact details
    @PutMapping("/{customerId}/update-contact")
    public ResponseEntity<CustomerResponseDto> updateContactDetails(
            @PathVariable int customerId,
            @RequestBody CustomerRequestDto customerRequestDto) {

        CustomerResponseDto customerContactDetail = customerService.updateContactDetails(customerId, customerRequestDto);
        if (customerContactDetail != null) {
            return ResponseEntity.ok(customerContactDetail);
        } else {
            // Handle case where customer is not found
            return ResponseEntity.notFound().build();
        }
    }

    // view rental history
//    @GetMapping("/{customerId}/rental-history")
//    public ResponseEntity<List<Rental>> getRentalHistory(@PathVariable int customerId){
//        List<Rental> rentalHistory = customerService.getRentalHistory(customerId);
//        return ResponseEntity.ok(rentalHistory);
//    }



}
