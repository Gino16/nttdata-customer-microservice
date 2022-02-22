package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Holder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolderRepository extends JpaRepository<Holder, Long> {
}
