package com.staxoverflow.demo.controller;


import com.staxoverflow.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.staxoverflow.demo.service.AccountService;

import java.util.List;

@RestController
@RequestMapping(value = "/base-account")
public class AccountController {

    @Autowired
    private AccountService service;

     // The 'delete' com.staxoverflow.demo.controller has NOT been implemented

    @PostMapping(value = "/create")
    public ResponseEntity<Account> create(
            @RequestBody Account account) {
        return new ResponseEntity<>(service.create(account),
                HttpStatus.CREATED);
    }
    @GetMapping(value = "/account-list")
    public ResponseEntity<List<Account>> getAllAccountList() {
        return new ResponseEntity<>(service.readAll(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/find-account-id/{id}")
    public ResponseEntity<Account> getAccountById(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.read(id),
                HttpStatus.OK);
    }

    @GetMapping(value = "/find-account-username/{username}")
    public ResponseEntity<Account> getAccountByUsername(
            @PathVariable String username) {
        return new ResponseEntity<>(service.readByUsername(username),
                HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update-account-username/{username}")
    public ResponseEntity<Account> updateUsername(
            @PathVariable String username,
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(
                service.updateUsername(id, username
        ), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update-account-email/{email}")
    public ResponseEntity<Account> updateEmail(
            @PathVariable String email,
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(
                service.updateEmail(id, email),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-account")
    public ResponseEntity<Account> delete() {
        return null;
    }
}
