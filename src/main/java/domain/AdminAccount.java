package domain;


import javax.persistence.Entity;
import java.util.List;

@Entity
public class AdminAccount extends Account{

    private List<GuestAccount> tripGroup;

    private List<Account> copayees;

    public AdminAccount() {
    }

    public AdminAccount(Long accountNum, String username,
                        String email, int phoneNumber,
                        String address, double balance,
                        Boolean tripStatus, Boolean permission,
                        List<Trip> trips, List<GuestAccount> tripGroup,
                        List<Account> copayees) {
        super(accountNum, username,
                email, phoneNumber,
                address, balance,
                tripStatus, permission,
                trips);
        this.tripGroup = tripGroup;
        this.copayees = copayees;
    }

    public List<GuestAccount> getTripGroup() {
        return tripGroup;
    }

    public void setTripGroup(List<GuestAccount> tripGroup) {
        this.tripGroup = tripGroup;
    }

    public List<Account> getCopayees() {
        return copayees;
    }

    public void setCopayees(List<Account> copayees) {
        this.copayees = copayees;
    }
}
