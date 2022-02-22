package com.nttdata.customers.services.impl;

import com.nttdata.customers.entities.Holder;
import com.nttdata.customers.repositories.HolderRepository;
import com.nttdata.customers.services.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolderServiceImpl implements HolderService {

    @Autowired
    private HolderRepository holderRepository;

    @Override
    public List<Holder> findAll() {
        return holderRepository.findAll();
    }

    @Override
    public Holder findOneById(Long id) {
        return holderRepository.findById(id).orElse(null);
    }

    @Override
    public Holder create(Holder holder) {
        return holderRepository.save(holder);
    }

    @Override
    public Holder edit(Long id, Holder holder) {
        Holder newHolder = this.findOneById(id);
        newHolder.setFirstnames(holder.getFirstnames());
        newHolder.setLastnames(holder.getLastnames());
        newHolder.setAddress(holder.getAddress());

        return holderRepository.save(newHolder);
    }

    @Override
    public void deleteById(Long id) {
        holderRepository.deleteById(id);
    }
}
