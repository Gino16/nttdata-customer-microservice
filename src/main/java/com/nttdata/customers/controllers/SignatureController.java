package com.nttdata.customers.controllers;

import com.nttdata.customers.entities.Signature;
import com.nttdata.customers.services.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/signature")
public class SignatureController {
    @Autowired
    private SignatureService signatureService;

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
    public ResponseEntity<Signature> create(@RequestBody Signature Signature){
        return new ResponseEntity<>(signatureService.create(Signature), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Signature> edit(@PathVariable Long id, @RequestBody Signature Signature){
        return new ResponseEntity<>(signatureService.edit(id, Signature), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        signatureService.deleteById(id);
    }

}
