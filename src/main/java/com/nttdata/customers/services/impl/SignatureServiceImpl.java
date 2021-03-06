package com.nttdata.customers.services.impl;

import com.nttdata.customers.entities.Signature;
import com.nttdata.customers.repositories.SignatureRepository;
import com.nttdata.customers.services.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignatureServiceImpl implements SignatureService {

    @Autowired
    private SignatureRepository signatureRepository;

    @Override
    public List<Signature> findAll() {
        return signatureRepository.findAll();
    }

    @Override
    public Signature findOneById(Long id) {
        return signatureRepository.findById(id).orElse(null);
    }

    @Override
    public Signature create(Signature Signature) {
        return signatureRepository.save(Signature);
    }

    @Override
    public Signature edit(Long id, Signature Signature) {
        Signature newSignature = this.findOneById(id);
        newSignature.setFirstnames(Signature.getFirstnames());
        newSignature.setLastnames(Signature.getLastnames());
        newSignature.setAddress(Signature.getAddress());

        return signatureRepository.save(newSignature);
    }

    @Override
    public void deleteById(Long id) {
        signatureRepository.deleteById(id);
    }
}
