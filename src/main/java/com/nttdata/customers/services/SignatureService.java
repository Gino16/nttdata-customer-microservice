package com.nttdata.customers.services;

import com.nttdata.customers.entities.Signature;

import java.util.List;

public interface SignatureService {
    public List<Signature> findAll();
    public Signature findOneById(Long id);
    public Signature create(Signature signature);
    public Signature edit(Long id, Signature signature);
    public void deleteById(Long id);
}
