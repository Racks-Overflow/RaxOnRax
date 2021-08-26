package domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String destination;
    private Integer groupSize;
    private Double tripEstimate;
    private Double groupBalance;
    private Double totalSpent;
    private Boolean isActive;
    List<Double> transactionHistory;
    private Integer tripLength;

    @OneToOne
    Account adminAccount;

    @ManyToMany
    private Set<Account> guestsInvited;
    private Set<Account> guestConfirmed;

    public Trip() {
    }

    public Trip(Long id, Date date, String destination,
                Integer groupSize, Integer tripLength, Double tripEstimate,
                Double groupBalance, Double totalSpent,
                Boolean isActive, List<Double> transactionHistory,
                Account adminAccount, Set<Account> guestsInvited, Set<Account> guestConfirmed) {
        this.id = id;
        this.date = date;
        this.destination = destination;
        this.groupSize = groupSize;
        this.tripLength =tripLength;
        this.tripEstimate = tripEstimate;
        this.groupBalance = groupBalance;
        this.totalSpent = totalSpent;
        this.isActive = isActive;
        this.transactionHistory = transactionHistory;
        this.adminAccount = adminAccount;
        this.guestsInvited = guestsInvited;
        this.guestConfirmed = guestConfirmed;
    }

    public Trip(Long id, String destination, Double tripEstimate, Account admin) {
        this(id, null, destination, 1, 7, tripEstimate, null,0.00,  false, null, admin, null, null);

    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public Double getTripEstimate() {
        return tripEstimate;
    }

    public void setTripEstimate(Double tripEstimate) {
        this.tripEstimate = tripEstimate;
    }

    public void setGroupBalance(Double groupBalance) {
        this.groupBalance = groupBalance;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public List<Double> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Double> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Account getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(Account adminAccount) {
        this.adminAccount = adminAccount;
    }

    public Set<Account> getGuestsInvited() {
        return guestsInvited;
    }

    public void setGuestsInvited(Set<Account> guestsInvited) {
        this.guestsInvited = guestsInvited;
    }

    public Set<Account> getGuestConfirmed() {
        return guestConfirmed;
    }

    public void setGuestConfirmed(Set<Account> guestConfirmed) {
        this.guestConfirmed = guestConfirmed;
    }


}
