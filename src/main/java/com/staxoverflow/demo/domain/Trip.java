package com.staxoverflow.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value =  TemporalType.DATE) //google how to change format
    private Date date;

    private String destination;
    private Integer groupSize;
    private Double tripEstimate;
    private Double groupBalance;
    private Double totalSpent ;
    private Double estimatePerPerson;
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


    @JsonManagedReference
    @OneToMany
    private Set<Account> attendees;

    public Trip() {
    }


    public Trip(Long id, Date date, String destination,
                Integer groupSize, Double tripEstimate,
                Double groupBalance, Double totalSpent,
                Double estimatePerPerson, Boolean isActive,
                Integer tripLength, Account adminAccount, Set<Account> guestsInvited) {
        this.id = id;
        this.date = date;
        this.destination = destination;
        this.groupSize = groupSize;
        this.tripEstimate = tripEstimate;
        this.groupBalance = groupBalance;
        this.totalSpent = totalSpent;
        this.estimatePerPerson = estimatePerPerson;
        this.isActive = isActive;
        this.tripLength = tripLength;
        this.adminAccount = adminAccount;
        this.guestsInvited = guestsInvited;
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

    public Double getEstimatePerPerson() {
        return estimatePerPerson;
    }

    public void setEstimatePerPerson(Double estimatePerPerson) {
        this.estimatePerPerson = estimatePerPerson;
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

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", date=" + date +
                ", destination='" + destination + '\'' +
                ", groupSize=" + groupSize +
                ", tripEstimate=" + tripEstimate +
                ", groupBalance=" + groupBalance +
                ", totalSpent=" + totalSpent +
                ", estimatePerPerson=" + estimatePerPerson +
                ", isActive=" + isActive +
                ", tripLength=" + tripLength +
                ", adminAccount=" + adminAccount +
                ", guestsInvited=" + guestsInvited +
                ", attendees=" + attendees +
                '}';
    }
}
