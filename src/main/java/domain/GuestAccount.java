package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GuestAccount extends Account {

    @ManyToOne
    @JsonIgnore
    private AdminAccount adminAccount;

    Boolean isGoing;
    Boolean isAuthorizedToPay;


}
