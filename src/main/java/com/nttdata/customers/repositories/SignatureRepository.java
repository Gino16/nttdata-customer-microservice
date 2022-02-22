package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
}
