package com.nttdata.customers.services.impl;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.CustomerType;
import com.nttdata.customers.repositories.CustomerRepository;
import com.nttdata.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOneById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer edit(Long id, Customer customer) {
        Customer newCustomer = this.findOneById(id);
        if(newCustomer ==  null){
            return null;
        }
        newCustomer.setName(customer.getName());
        newCustomer.setIdentDoc(customer.getIdentDoc());

        return customerRepository.save(newCustomer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerType> findAllTypeCustomers(){
        return customerRepository.findAllCustomerTypes();
    }
}
