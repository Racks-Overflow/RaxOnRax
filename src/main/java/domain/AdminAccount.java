package domain;


import javax.persistence.Entity;
import java.util.List;

@Entity
public class AdminAccount extends Account{

    List<GuestAccount> tripGroup;

    List<Account> copayees;
}
