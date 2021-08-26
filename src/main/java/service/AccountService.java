package service;


import domain.Account;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    /* will need to include exception handling upon
      * creating an account if an account already
      * exists with the 'Account' s respective fields
    */

    public Account create(Account account) {
        return repo.save(account);
    }

    public Account read(Long id) {
        try {
            return repo.findById(id).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("There is " +
                    "no account with that ID");
        }
    }

    public Account readByUsername(String username) {
        try {
            List<Account> accList = new ArrayList<>();
            readAll().forEach(account -> {
                if (account.getUsername().equals(username))
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
        Account originalAccount = repo.findById(id).get();
        originalAccount.setUsername(newUserName);
        return repo.save(originalAccount);
    }

    public Account updateBalance(Long id, double input) { //input can be positive or negative
        Account originalAccount = repo.findById(id).get();
        double newBalanceOfAcc = originalAccount.getBalance() + input;
        originalAccount.setBalance(newBalanceOfAcc);
        return repo.save(originalAccount);
    }
    public Account delete(Account account) {
        repo.delete(account);
        return account;
    }

    public Account delete(Long id) {
        return delete(read(id));
    }


}
