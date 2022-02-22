package com.nttdata.customers.services;



import com.nttdata.customers.entities.Holder;

import java.util.List;

public interface HolderService {
    public List<Holder> findAll();
    public Holder findOneById(Long id);
    public Holder create(Holder holder);
    public Holder edit(Long id, Holder holder);
    public void deleteById(Long id);

}
