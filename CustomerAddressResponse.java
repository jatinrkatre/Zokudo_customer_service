package com.customer.zokudo.dto.response;

import javax.persistence.Column;

import com.customer.zokudo.enums.Status;

import lombok.Data;

@Data
public class CustomerAddressResponse {

	    private String firstName;
	    private String lastName;
	    private String address1;
	    private String address2;
	    private String city;
	    private String state;
	    private String country;
	    private String zipCode;
	    private String email;
	    private String mobile;
	    private Status kycType;
	    private String idType;
	    private String idNumber;
	    private String idExpiryDate;
	    private Status status;
	    

}
