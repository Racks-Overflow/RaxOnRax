package com.staxoverflow.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staxId;

    private String username;
    private String password;
    private String appEmail;
    private Double balance;
    private Boolean isGoing;

    public enum Role {
        ADMIN,
        GUEST};

    @OneToOne
    private Trip adminTrip;

    @OneToOne
    private BankAccount account;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "active_trip_id", referencedColumnName = "id")
    private Trip activeTrip;

    @ManyToMany
    @JoinTable (
            joinColumns = @JoinColumn (name = "staxId"),
            inverseJoinColumns = @JoinColumn (name = "trip_id")
    )
    List<Trip> trips = new ArrayList<>();

    public Account() {
    }

    public Account(Long staxId,
                   String username,
                   String password,
                   String appEmail,
                   Double balance) {
        this.staxId = staxId;
        this.username = username;
        this.password = password;
        this.appEmail = appEmail;
        this.balance = balance;
    }

//    public Account(Long staxId, List<Trip> trips,
//                   Trip adminTrip, String username,
//                   String password, String appEmail,
//                   Double balance, BankAccount account,
//                   Boolean isGoing) {
//        this.staxId = staxId;
//        this.trips = trips;
//        this.adminTrip = adminTrip;
//        this.username = username;
//        this.password = password;
//        this.appEmail = appEmail;
//        this.balance = balance;
//        this.account = account;
//        this.isGoing = isGoing;
//    }

//    public Account (Long id, List<Trip> trips,
//                    String username, BankAccount account,
//                    String password, Double balance,
//                    Boolean isGoing){
//        this(id, trips,
//                null, username,
//                password, null,
//                balance, account, false );
//    }


    public Long getStaxId() {
        return staxId;
    }

    public void setStaxId(Long staxId) {
        this.staxId = staxId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppEmail() {
        return appEmail;
    }

    public void setAppEmail(String appEmail) {
        this.appEmail = appEmail;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Trip getAdminTrip() {
        return adminTrip;
    }

    public void setAdminTrip(Trip adminTrip) {
        this.adminTrip = adminTrip;
    }

    public Boolean getGoing() {
        return isGoing;
    }

    public void setGoing(Boolean going) {
        isGoing = going;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Trip getActiveTrip() {
        return activeTrip;
    }

    public void setActiveTrip(Trip active) {
        this.activeTrip = active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "staxId=" + staxId +
                ", trips=" + trips +
                ", activeTrip=" + activeTrip +
                ", adminTrip=" + adminTrip +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", appEmail='" + appEmail + '\'' +
                ", balance=" + balance +
                ", account=" + account +
                ", isGoing=" + isGoing +
                '}';
    }
}
