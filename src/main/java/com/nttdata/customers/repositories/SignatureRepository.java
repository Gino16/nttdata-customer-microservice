package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
}
