package com.staxoverflow.demo.controller;


import com.staxoverflow.demo.domain.BankAccount;
import com.staxoverflow.demo.repository.BankAccRepo;
import com.staxoverflow.demo.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @PostMapping(value = "/add-bank-account")
    public ResponseEntity<BankAccount> create(
            @RequestBody BankAccount account) {
        return new ResponseEntity<>(service.create(account),
                HttpStatus.CREATED);
    }


    @GetMapping(value = "/list-of-bank-account")
    public ResponseEntity<List<BankAccount>> getBankAccountList() {
        return new ResponseEntity<>(service.readAll(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/bank-account/{accountNum}")
    public ResponseEntity<BankAccount> getBankAccountById(
        @PathVariable Long accountNum) {
        return new ResponseEntity<>(service.readByAccountNum(accountNum),
                HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<BankAccount> update(
            @PathVariable Long id,
            @RequestBody BankAccount account) {
        return new ResponseEntity<>(service.update(id, account),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-bank-acc")
    public ResponseEntity<BankAccount> delete(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id),
                HttpStatus.ACCEPTED);
    }
}
