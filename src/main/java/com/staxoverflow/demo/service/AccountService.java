package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.Account;
import com.staxoverflow.demo.domain.Trip;
import com.staxoverflow.demo.exception.ResourceNotFoundException;
import com.staxoverflow.demo.exception.RestExceptionHandler;
import com.staxoverflow.demo.exception.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.staxoverflow.demo.repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements Validator {

    @Autowired
    private AccountRepo repo;



    /* will need to include com.staxoverflow.demo.exception handling upon
      * creating an account if an account already
      * exists with the 'Account' s respective fields
    */

    /*
        * implement bank account connection between accounts and Bank Accounts
     */

    public Boolean checkDatabaseForExistingUsername(String userInput) {
        return readByUsername(userInput) != null; //There's an account with that field
    }

    public Boolean checkDatabaseForExistingEmail(String userInput) {
        return readByEmail(userInput) != null; //There's an account with that field
    }

//    public Account create(Account account) {
//        if (checkDatabaseForExistingEmail(account.getAppEmail()) ||
//                checkDatabaseForExistingUsername(account.getUsername())) {
//            throw new ResourceNotFoundException("An account already exists with that information");
//        }
//        return repo.save(account);
//    }
    public boolean validateEmail(Account account) {
        return validateEmail(account.getAppEmail());
    }

    public boolean validateUsername(Account account) {
        return validateUsername(account.getUsername());
    }

    public Account create(Account account) {
    //    if(validateEmail(account) || validateUsername(account.getUsername()))
            return repo.save(account);
    }

    public Account read(Long id) {
        return repo.findById(id).get();
    }

    public List<Account> readByUsername(String username) {
            return readAll()
                    .stream().filter(account ->
                            account.getUsername().equals(username))
                    .collect(Collectors.toList());
    }

    public Account readByEmail(String userInput) {
            List<Account> accList = new ArrayList<>();
            readAll().forEach(account -> {
                if (account.getAppEmail().equals(userInput))
                    accList.add(account);
            });
            return accList.get(0);
    }

    public List<Account> readAll() {
        Iterable<Account> accountIterable = repo.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }

    public Account updateUsername(Long id, String newUserName) {
        Account originalAccount = read(id);
        originalAccount.setUsername(newUserName);
        return repo.save(originalAccount);
    }

    public Account updateBalance(Long id, double input) { //input can be positive or negative
        Account originalAccount = read(id);
        double newBalanceOfAcc = originalAccount.getBalance() + input;
        originalAccount.setBalance(newBalanceOfAcc);
        return repo.save(originalAccount);
    }

    public Account updateEmail(Long id, String newEmail) {
        Account ogAcc = read(id);
        ogAcc.setAppEmail(newEmail);
        repo.save(ogAcc);
        return ogAcc;
    }

    public Account updateIsGoing(Long id) {
        Account ogAcc = read(id);
        ogAcc.setGoing(true);
        repo.save(ogAcc);
        return ogAcc;
    }

    public Account updateIsNotGoing(Long id) {
        Account ogAcc = read(id);
        ogAcc.setGoing(false);
        repo.save(ogAcc);
        return ogAcc;
    }

    public Account updateIsGoingButTripEnded(Long id) {
        Account ogAcc = read(id);
        ogAcc.setGoing(null);
        repo.save(ogAcc);
        return ogAcc;
    }

    public Account delete(Account account) {
            repo.delete(account);
            return account;
    }

    public Account delete(Long id) {
        return delete(read(id));
    }
}
