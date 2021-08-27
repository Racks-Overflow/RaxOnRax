package com.staxoverflow.demo.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(value =  TemporalType.DATE)
    private Date date;

    private String destination;
    private Integer groupSize;
    private Double tripEstimate;
    private Double groupBalance;
    private Double totalSpent;
    private Boolean isActive;
//    private List<Double> transactionHistory;
    private Integer tripLength; //days

    @OneToOne
    Account adminAccount;

    @ManyToMany
    @JoinTable (
            joinColumns = @JoinColumn (name = "trip_id"),
            inverseJoinColumns = @JoinColumn (name = "account_id")
    )
    private Set<Account> guestsInvited = new HashSet<>();


    public Trip() {
    }

    public Trip(Date date, String destination,
                Integer groupSize, Integer tripLength, Double tripEstimate,
                Double groupBalance, Double totalSpent,
                Boolean isActive,
                Account adminAccount, Set<Account> guestsInvited) {
        this.date = date;
        this.destination = destination;
        this.groupSize = groupSize;
        this.tripLength =tripLength;
        this.tripEstimate = tripEstimate;
        this.groupBalance = groupBalance;
        this.totalSpent = totalSpent;
        this.isActive = isActive;
        this.adminAccount = adminAccount;
        this.guestsInvited = guestsInvited;
    }

    public Trip(Long id, String destination, Double tripEstimate, Account admin) {
        this(null, destination,
                1, 7,
                tripEstimate, null,
                0.00,  false,
                admin, null);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getGroupBalance() {
        return groupBalance;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getTripLength() {
        return tripLength;
    }

    public void setTripLength(Integer tripLength) {
        this.tripLength = tripLength;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getGroupSize() {
        return getGuestsInvited().size();
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


    public void inviteGuest(Account account) {
        guestsInvited.add(account);
    }

    public void assignAdmin(Account account) {
        setAdminAccount(account);
    }

    public void removeGuest(Account account) {
        guestsInvited.remove(account);
    }
}
