package com.staxoverflow.demo.domain;

import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class BankAccount {
    @Id
    @Column(name = "bankAccountNumber")
    @Size()
    private Long accountNum;
    private String firstName;
    private String lastName;
    @Column(name = "phoneNumber", length = 10)
    private String phoneNumber; // preset length of phoneNum in SQL table
    private Address address;


    @OneToOne
    Account account;

    public BankAccount() { }

    public BankAccount(Long accountNum,
                       String firstName,
                       String lastName,
                       String phoneNumber,
                       Address address,
                       Account account) {
        this.accountNum = accountNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public BankAccount(Long accountNum) {
        this(accountNum, "First Name",
                 "Last Name",
                 null,
                null, null);

    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
