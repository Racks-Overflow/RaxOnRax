package configurations;

import domain.AdminAccount;
import domain.GuestAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import repository.AdminAccountRepo;
import service.AccountService;

import javax.annotation.PostConstruct;

@Configuration
public class GuestAccountConfig {

    @Autowired
    AccountService accountService;

    @Autowired
    AdminAccountRepo groupRepo;

    @PostConstruct
    public void setUp(){
        accountService.create(new GuestAccount());
        //make a set in AdminAccount Set
    }
}
