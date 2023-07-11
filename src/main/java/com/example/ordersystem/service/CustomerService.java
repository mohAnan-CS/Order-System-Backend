package com.example.ordersystem.service;

import com.example.ordersystem.dto.CustomerDTO;
import com.example.ordersystem.exception.ResourceNotFoundException;
import com.example.ordersystem.model.Customer;
import com.example.ordersystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public ResponseEntity<CustomerDTO> addCustomer(CustomerDTO customerDTO){

        Customer customer = mapToEntity(customerDTO);
        customerRepository.save(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);

    }

    public CustomerDTO getCustomer(long id){

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        return mapToDTO(customer);

    }

    private Customer mapToEntity(CustomerDTO customerDTO ){

        Customer customer = new Customer();
        customer.setFirst_name(customerDTO.getFirstName());
        customer.setLast_name(customerDTO.getLastName());
        customer.setBornAt(customerDTO.getDate());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        return customer;

    }

    private CustomerDTO mapToDTO(Customer customer){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(customer.getFirst_name());
        customerDTO.setLastName(customer.getLast_name());
        customerDTO.setDate(customer.getBornAt());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPassword(customer.getPassword());
        return customerDTO;

    }

}
