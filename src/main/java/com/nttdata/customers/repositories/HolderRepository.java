package com.nttdata.customers.repositories;

import com.nttdata.customers.entities.Holder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HolderRepository extends JpaRepository<Holder, Long> {
}
