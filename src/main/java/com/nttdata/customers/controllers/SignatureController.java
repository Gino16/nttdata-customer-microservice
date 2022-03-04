package com.nttdata.customers.controllers;

import com.nttdata.customers.entities.Customer;
import com.nttdata.customers.entities.Signature;
import com.nttdata.customers.services.CustomerService;
import com.nttdata.customers.services.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/signature")
public class SignatureController {
    @Autowired
    private SignatureService signatureService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Signature>> findAll(){
        return  new ResponseEntity<>(signatureService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signature> findOneById(@PathVariable Long id){
        Signature Signature = signatureService.findOneById(id);

        if (Signature == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Signature, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Signature> create(@RequestBody Signature signature){

        try{
            Customer customer = customerService.findOneById(signature.getCustomer().getId());
            if (Objects.equals(customer.getCustomerType().getName(), "Personal")){
                return ResponseEntity.badRequest().build();
            }
            return new ResponseEntity<>(signatureService.create(signature), HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Signature> edit(@PathVariable Long id, @RequestBody Signature signature){
        return new ResponseEntity<>(signatureService.edit(id, signature), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        signatureService.deleteById(id);
    }

}
