package com.nttdata.customers.services;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.CustomerType;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer findOneById(Long id);
    public Customer create(Customer customer);
    public Customer edit(Long id, Customer customer);
    public void deleteById(Long id);

    public List<CustomerType> findAllTypeCustomers();
}
