package com.customer.zokudo.entities;

import com.customer.zokudo.enums.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="customer_kyc")
public class CustomerKycDetails extends  AbstractEntity {

    @Column(name="address_1" , nullable = false)
    private String address1;

    @Column(name="address_2" , nullable = true)
    private String address2;

    @Column(name="city" , nullable = false)
    private String city;

    @Column(name="state" , nullable = false)
    private String state;

    @Column(name="country" , nullable = false)
    private String country;

    @Column(name="zip_code" , nullable = false)
    private String zipCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
