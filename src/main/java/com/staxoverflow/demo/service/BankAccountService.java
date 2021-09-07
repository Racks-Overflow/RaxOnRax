package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.BankAccount;
import com.staxoverflow.demo.exception.ResourceNotFoundException;
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

    public BankAccount readByAccountNum(Long accountNum) {
           return repo.findById(accountNum).orElseThrow(() -> new ResourceNotFoundException(
                   "That bank account doesn't exist"));
    }

    /* I left the 'update account' (the field that links
        the AppAccount and the BankAccount) intentionally
        left out -- a user should have NO access
        rewriting the OneToOne
     */
    public BankAccount update(Long accountNum,
                              BankAccount newInfo) {
        BankAccount inDb = readByAccountNum(accountNum);
        inDb.setAccountNum(newInfo.getAccountNum());
        inDb.setFirstName(newInfo.getFirstName());
        inDb.setLastName(newInfo.getLastName());
        inDb.setPhoneNumber(newInfo.getPhoneNumber());
        inDb.setAddress(newInfo.getAddress());
        inDb = repo.save(inDb);
        return inDb;
    }

    public BankAccount delete(Long accountNum) {
        BankAccount inDb = readByAccountNum(accountNum);
        repo.delete(inDb);
        return inDb;
    }

    public BankAccount delete(BankAccount account) {
        return delete(account.getAccountNum());
    }
}
