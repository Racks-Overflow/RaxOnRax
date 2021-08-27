package com.staxoverflow.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
    @Id
    Long accountNum;
    String govtName;
    String email;
    String phoneNumber; // preset length of phoneNum in SQL table
    String address;

    @OneToOne
    Account account;

    public BankAccount() { }

    public BankAccount(Long accountNum, String govtName,
                       String email, String phoneNumber,
                       String address, Account account) {
        this.accountNum = accountNum;
        this.govtName = govtName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public BankAccount(Long accountNum) {
        this(accountNum, "User",
                null, null,
                null, null);

    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getGovtName() {
        return govtName;
    }

    public void setGovtName(String govtName) {
        this.govtName = govtName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
