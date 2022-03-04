package com.nttdata.customers.controllers;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.Holder;
import com.nttdata.customers.services.CustomerService;
import com.nttdata.customers.services.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/holders")
public class HolderController {

    @Autowired
    private HolderService holderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Holder>> findAll(){
        return  new ResponseEntity<>(holderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holder> findOneById(@PathVariable Long id){
        Holder Holder = holderService.findOneById(id);

        if (Holder == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Holder, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Holder> create(@RequestBody Holder holder){
        try {
            Customer customer = customerService.findOneById(holder.getCustomer().getId());
            if (Objects.equals(customer.getCustomerType().getName(), "Personal")){
                return ResponseEntity.badRequest().build();
            }
            return new ResponseEntity<>(holderService.create(holder), HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holder> edit(@PathVariable Long id, @RequestBody Holder holder){
        return new ResponseEntity<>(holderService.edit(id, holder), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        holderService.deleteById(id);
    }

}
