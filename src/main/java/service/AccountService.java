package service;


import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    public Account create(Account account) {
        return repo.save(account);
    }

    public Account read(Long id) {
        return repo.findById(id).get();
    }

    public List<Account> readAll() {
        Iterable<Account> accountIterable = repo.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }

    public Account update(Long id, Account newAccountData) {
        return null;
    }

    public Account delete(Account account) {
        repo.delete(account);
        return account;
    }

    public Account delete(Long id) {
        return delete(read(id));
    }
}
