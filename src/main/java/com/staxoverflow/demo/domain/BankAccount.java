package com.staxoverflow.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class BankAccount {
    @Id
    @Size(min = 8, max = 12)
    private Long accountNum;
    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Size(min = 10, max = 10)
    private Integer phoneNumber;
    @Embedded
    private Address address;

    @OneToOne
    Account account;

    public BankAccount(Long accountNum,
                       String firstName,
                       String lastName,
                       Integer phoneNumber,
                       Address address,
                       Account account) {
        this.accountNum = accountNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public BankAccount(Long accountNum, Account account) {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
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

}
