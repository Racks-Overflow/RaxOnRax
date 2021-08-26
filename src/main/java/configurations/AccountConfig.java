package configurations;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import service.AccountService;

import javax.annotation.PostConstruct;

@Configuration
public class AccountConfig {

    @Autowired
    AccountService accountService;


    @PostConstruct
    public void setUp(){
        accountService.create(new Account());
    }
}
