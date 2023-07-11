package com.example.ordersystem.controller;

import com.example.ordersystem.dto.CustomerDTO;
import com.example.ordersystem.model.Customer;
import com.example.ordersystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    public CustomerService customerServices;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerServices.getAllCustomers());
    }

}
