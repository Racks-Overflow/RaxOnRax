package controller;


import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/base-account")
public class AccountController {

    @Autowired
    private AccountService service;

    //holding off on update controller

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
}
