package com.customer.zokudo.dto.request;

import com.customer.zokudo.entities.Customer;
import lombok.Data;

@Data
public class CommonRequestDTO {

    private Customer customer;
    private String kycDetailsHashId;
    private double confData;
    private int programId;
    private String programName;
}
