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

    public Account update(Long id, Account newAccountData) {
        Account originalAccount = repo.findById(id).get();
        originalAccount.setAccountNum(newAccountData.getAccountNum());
        originalAccount.setEmail(newAccountData.getEmail());
        originalAccount.setAddress(newAccountData.getAddress());
        originalAccount.setBalance(newAccountData.getBalance());
        originalAccount.setUsername(newAccountData.getUsername());
        originalAccount.setTripStatus(newAccountData.getTripStatus());
        originalAccount.setPermission(newAccountData.getPermission());
        originalAccount.setTrips(newAccountData.getTrips());
        originalAccount.setAdmin(newAccountData.getAdmin());
        originalAccount.setPermission(newAccountData.getPermission());
        return repo.save(originalAccount);
    }

    public Account delete(Account account) {
        repo.delete(account);
        return account;
    }

    public Account delete(Long id) {
        return delete(read(id));
    }

    public Account depositToTrip(Long id, double input) {
        Account accountInDb = read(id);
        double newBalanceOfAcc = accountInDb.getBalance() + input;
        accountInDb.setBalance(newBalanceOfAcc);
        update(id, accountInDb);

        return accountInDb;
    }
}
