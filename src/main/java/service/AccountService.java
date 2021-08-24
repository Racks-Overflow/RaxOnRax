package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepo;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;
}
