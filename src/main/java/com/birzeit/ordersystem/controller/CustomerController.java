package com.birzeit.ordersystem.controller;

import com.birzeit.ordersystem.model.Customer;
import com.birzeit.ordersystem.dto.CustomerDTO;
import com.birzeit.ordersystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(customerServices.getCustomer(id));
    }

}
