package configurations;

import domain.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import repository.AccountRepo;
import service.AccountService;

import javax.annotation.PostConstruct;

@Configuration
public class AdminAccountConfig {
    @Autowired
    AccountService accountService;

    @Autowired
    private AccountRepo repo;

    @PostConstruct
    public void setUp(){
        accountService.create(new AdminAccount());

    }
}
