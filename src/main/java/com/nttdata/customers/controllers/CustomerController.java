package com.nttdata.customers.controllers;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.CustomerType;
import com.nttdata.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAll(){
        return  new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findOneById(@PathVariable Long id){
        Customer customer = customerService.findOneById(id);

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable Long id, @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.edit(id, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        customerService.deleteById(id);
    }

    @GetMapping("/types")
    public ResponseEntity<List<CustomerType>> findAllTypeCustomers(){
        return new ResponseEntity<>(customerService.findAllTypeCustomers(), HttpStatus.OK);
    }
}
