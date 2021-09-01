package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.BankAccount;
import com.staxoverflow.demo.repository.BankAccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccRepo repo;

    public BankAccount create(BankAccount account) {
        return repo.save(account);
    }

    public List<BankAccount> readAll() {
        Iterable<BankAccount> accountIterable = repo.findAll();
        List<BankAccount> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }


}
