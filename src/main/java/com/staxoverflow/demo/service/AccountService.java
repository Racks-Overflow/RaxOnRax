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

    public boolean checkDBForEmail(String appEmail) {
        List<Account> accountList = readAll();
        for (Account account : accountList) {
            if (account.getAppEmail().equals(appEmail)) {
                return true; //email is in db
            }
        }
        return false; //email not in db
    }

    public boolean checkDBForUsername(String username) {
        List<Account> accountList = readAll();
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return true; //username is in db
            }
        }
        return false; //username not in db
    }

    // need to actually use this -- more research req.
    public Account loginAccount(String username, String password) {
        Account inDb = readByUsername(username);
        if (inDb.getPassword().equals(password)) {
            return inDb;
        }
        throw new ResourceNotFoundException("Username and/or password are incorrect");
    }

    public Account create(Account account) throws Exception{
        if (checkDBForEmail(account.getAppEmail())) {
            throw new Exception("That email is already in use");
        } else if (checkDBForUsername(account.getUsername())) {
            throw new Exception("That username is already in use");
        } else if (!validateEmail(account.getAppEmail())) {
            throw new Exception("Your email does not meet our criteria");
        } else if (!validateUsername(account.getUsername())) {
            throw new Exception("Your username does not meet our criteria");
        } else if (!validatePassword(account.getPassword())) {
            throw new Exception("You password does NOT meet the requirements");
        } else {
            return repo.save(account);
        }
    }

    public Account read(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "That account doesn't exist"));
    }

    public Account readByUsername(String username) {
//            return (Account) readAll()
//                    .stream().filter(account ->
//                            account.getUsername().equals(username));
        List<Account> accountList = readAll();
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        throw new ResourceNotFoundException("That account doesn't exist");
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
