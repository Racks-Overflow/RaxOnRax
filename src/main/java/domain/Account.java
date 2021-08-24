package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNum;

    private String username;
    private String email;
    private int phoneNumber; // preset length of phoneNum in SQL table
    private String address;
    private double balance;
    private Boolean tripStatus;
    private Boolean permission;

    List<Trip> trips;

    public Account() {
    }

    public Account(int accountNum, String username,
                   String email, int phoneNumber,
                   String address, double balance,
                   Boolean tripStatus, Boolean permission,
                   List<Trip> trips) {
        this.accountNum = accountNum;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
        this.tripStatus = tripStatus;
        this.permission = permission;
        this.trips = trips;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Boolean getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(Boolean tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
