package com.customer.zokudo.dto.request;

import com.customer.zokudo.entities.Category;
import com.customer.zokudo.enums.BrandCategory;
import com.customer.zokudo.enums.ProgramPlans;
import lombok.Data;

import java.util.List;

@Data
public class CustomerAppRequestDTO {

    String mobile;
    String userName;
    String password;
    String confirmPassword;
    String oldPassword;
    String deviceId;
    String otp;
    ProgramPlans programPlan;
    int programId;
    List<String> categoryList;
    String token;
    String address1;
    String email;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zipCode;


}
