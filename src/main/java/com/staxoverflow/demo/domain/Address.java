package com.staxoverflow.demo.domain;


import javax.validation.constraints.Size;

public class Address {

    private String number;
    private String street;
    private String city;
    
    private String zipcode;

    public Address(String number, String street, String city, String zipcode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
