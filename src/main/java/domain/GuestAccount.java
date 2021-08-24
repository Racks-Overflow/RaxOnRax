package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class GuestAccount extends Account {

    @ManyToOne
    @JsonIgnore
    private AdminAccount adminAccount;

    private Boolean isGoing;
    private Boolean isAuthorizedToPay;

    public GuestAccount() {
    }

    public GuestAccount(Long accountNum, String username,
                        String email, int phoneNumber,
                        String address, double balance,
                        Boolean tripStatus, Boolean permission,
                        List<Trip> trips, AdminAccount adminAccount,
                        Boolean isGoing, Boolean isAuthorizedToPay) {
        super(accountNum, username,
                email, phoneNumber,
                address, balance,
                tripStatus, permission,
                trips);
        this.adminAccount = adminAccount;
        this.isGoing = isGoing;
        this.isAuthorizedToPay = isAuthorizedToPay;
    }

    public AdminAccount getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(AdminAccount adminAccount) {
        this.adminAccount = adminAccount;
    }

    public Boolean getGoing() {
        return isGoing;
    }

    public void setGoing(Boolean going) {
        isGoing = going;
    }

    public Boolean getAuthorizedToPay() {
        return isAuthorizedToPay;
    }

    public void setAuthorizedToPay(Boolean authorizedToPay) {
        isAuthorizedToPay = authorizedToPay;
    }
}
