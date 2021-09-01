package com.staxoverflow.demo.domain;


import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
@Embeddable
public class Address {

    private String number;
    private String street;
    private String city;
    @Size(min = 5, max = 5)
    private int zipcode;

    public Address(String number,
                   String street,
                   String city,
                   int zipcode) {
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
