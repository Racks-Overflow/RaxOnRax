package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.Account;
import com.staxoverflow.demo.domain.Trip;
import com.staxoverflow.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.staxoverflow.demo.repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    /* will need to include com.staxoverflow.demo.exception handling upon
      * creating an account if an account already
      * exists with the 'Account' s respective fields
    */

//    public Boolean checkDatabaseForExistingUsername(String userInput) {
//        return readByUsername(userInput) != null; //There's an account with that field
//    }
//
//    public Boolean checkDatabaseForExistingEmail(String userInput) {
//        return readByEmail(userInput) != null; //There's an account with that field
//    }
//
//    public Account create(Account account) {
//        if (checkDatabaseForExistingEmail(account.getAppEmail()) ||
//                checkDatabaseForExistingUsername(account.getUsername())) {
//            throw new ResourceNotFoundException("An account already exists with that information");
//        }
//        return repo.save(account);
//    }

    public Account create(Account account) {
        return repo.save(account);
    }

    public Account read(Long id) {
        return repo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist"));
    }

    public List<Account> readByUsername(String username) {
            return readAll()
                    .stream().filter(account ->
                            account.getUsername().equals(username))
                    .collect(Collectors.toList());
    }

    public Account readByEmail(String userInput) {
        try {
            List<Account> accList = new ArrayList<>();
            readAll().forEach(account -> {
                if (account.getAppEmail().equals(userInput))
                    accList.add(account);
            });
            return accList.get(0);
        } catch (Exception e) {
            throw new ResourceNotFoundException("There is no " +
                    "account with that username");
        }
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

    public Account updateActiveTrip(Long id, Trip trip) {
        Account original = read(id);
        original.setActiveTrip(trip);
        return repo.save(original);
    }

    public Account delete(Account account) {
        if (account.getBalance() > 0.0 || account.getBalance() < 0.0) {
            throw new ResourceNotFoundException("You must set your balance to $0.00 before deletion");
        } else {
            repo.delete(account);
            return account;
        }
    }



    public Account delete(Long id) {
        return delete(read(id));
    }
}
