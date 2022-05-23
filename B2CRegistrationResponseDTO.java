package com.customer.zokudo.dto.response;

import com.customer.zokudo.entities.Customer;
import lombok.Data;

@Data
public class B2CRegistrationResponseDTO {
    boolean isB2cRegistered;
    int b2CProgramId;
    String b2CProgramName;
    String kycStatus;
}
