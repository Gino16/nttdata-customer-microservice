package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.CustomerType;
import com.nttdata.customers.entities.Holder;
import com.nttdata.customers.entities.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT ct FROM CustomerType ct")
    public List<CustomerType> findAllCustomerTypes();

    @Query("SELECT h from Holder h where h.customer.id = :id")
    public List<Holder> findHoldersByCustomer(Long id);

    @Query("SELECT s from Signature s where s.customer.id = :id")
    public List<Signature> findSignaturesByCustomer(Long id);
}
