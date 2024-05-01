package com.siddharth.carrentalsystem.Service;

import com.siddharth.carrentalsystem.Dtos.CustomerRequestDto;
import com.siddharth.carrentalsystem.Dtos.CustomerResponseDto;
import com.siddharth.carrentalsystem.Repository.CustomerRepository;
import com.siddharth.carrentalsystem.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //create
//    public void createCustomer(CustomerRequestDto customerRequestDto) {
//        Customer customer = mapRequestDtoToEntity(customerRequestDto);
//        customerRepository.save(customer);
//    }
    public Customer createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = mapRequestDtoToEntity(customerRequestDto);
        return customerRepository.save(customer);
    }

    //update
//    public void updateCustomer(int customerId, CustomerRequestDto customerRequestDto) {
//        Optional<Customer> optionalCustomer = customerRepository.findById((long) customerId);
//        optionalCustomer.ifPresent(customer -> {
//            mapRequestDtoToEntity(customerRequestDto, customer);
//            customerRepository.save(customer);
//        });
//    }
    public Customer updateCustomer(int customerId, CustomerRequestDto customerRequestDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById((long) customerId);
        return optionalCustomer.map(customer -> {
            mapRequestDtoToEntity(customerRequestDto, customer);
            return customerRepository.save(customer);
        }).orElse(null); // Handle the case where customer is not found
    }

    //delete
//    public void deleteCustomer(int customerId) {
//        customerRepository.deleteById((long) customerId);
//    }
    public Customer deleteCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById((long) customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customerRepository.deleteById((long) customerId);
            return customer;
        } else {
            // If customer with the given ID does not exist, you can return null or throw an exception
            return null;
        }
    }

    //read
    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById((long) customerId);
        return optionalCustomer.orElse(null);
    }


    //update the contact details
    public CustomerResponseDto updateContactDetails(int customerId, CustomerRequestDto customerRequestDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById((long) customerId);
        return optionalCustomer.map(customer -> {
            mapRequestDtoToEntity(customerRequestDto, customer);
            customerRepository.save(customer);
            return mapEntityToResponseDto(customer);
        }).orElse(null);
    }


    private Customer mapRequestDtoToEntity(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setLicenseNumber(customerRequestDto.getLicenseNumber());
        customer.setPhone(customerRequestDto.getPhone());
        customer.setEmail(customerRequestDto.getEmail());
        // Set other properties as needed
        return customer;
    }

    private void mapRequestDtoToEntity(CustomerRequestDto customerRequestDto, Customer customer) {
        customer.setName(customerRequestDto.getName());
        customer.setLicenseNumber(customerRequestDto.getLicenseNumber());
        customer.setPhone(customerRequestDto.getPhone());
        customer.setEmail(customerRequestDto.getEmail());
        // Set other properties as needed
    }

    private CustomerResponseDto mapEntityToResponseDto(Customer customer) {
        CustomerResponseDto responseDto = new CustomerResponseDto();
        responseDto.setCustomerID(customer.getCustomerId());
        responseDto.setName(customer.getName());
        responseDto.setLicenseNumber(customer.getLicenseNumber());
        responseDto.setPhone(customer.getPhone());
        responseDto.setEmail(customer.getEmail());
        // Map other properties as needed
        return responseDto;
    }
}