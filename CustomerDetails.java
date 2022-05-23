package com.customer.zokudo.entities;


import com.customer.zokudo.enums.Status;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer_details")
public class CustomerDetails extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "gender", nullable = false)
    private String gender;

    /*@Column(name = "birthday", nullable = false)
    //@Temporal(TemporalType.DATE)
    private Date birthday;*/
    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "id_type", nullable = false)
    private String idType;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(name = "country_of_issue", nullable = false)
    private String countryOfIssue;

    /*@Column(name = "id_expiry", nullable = true)
    //@Temporal(TemporalType.DATE)
    private Date idExpiryDate;*/
    @Column(name = "id_expiry", nullable = true)
    private String idExpiryDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, unique = true)
    private CustomerKycDetails customerKycDetails;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public CustomerKycDetails getCustomerKycDetails() {
        return customerKycDetails;
    }

    public void setCustomerKycDetails(CustomerKycDetails customerKycDetails) {
        this.customerKycDetails = customerKycDetails;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }
}
