package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT ct FROM CustomerType ct")
    public List<CustomerType> findAllCustomerTypes();
}
