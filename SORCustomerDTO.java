package com.customer.zokudo.dto.request;


import com.customer.zokudo.enums.ProgramPlans;
import com.customer.zokudo.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class SORCustomerDTO {

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String customerHashId;
    private String title;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String contactNo;
    private String gender;
    private String dob;
    private String documentType;
    private String documentNo;
    private String documentExpDate;
    private String emailAddress;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private Status kycType;
    private Status status;
    private String countryOfIssue;
    private String kycRefNo;
    private ProgramPlans programType;
    private String programName;
    private String programHashId;
    private int programId;
    private String preferredName;


}
