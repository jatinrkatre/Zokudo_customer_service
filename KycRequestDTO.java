package com.customer.zokudo.dto.request;

import lombok.Data;

@Data
public class KycRequestDTO {

    private String kycRequestId;
    private String referenceId;
    private String transactionId;
    private String customerName;
    private String mobile;
    private String customerIdentifier;
    private String expireInDays;
    private String createdAt;
    private String validTill;
    private String status;
    private String customerHashId;
    private String workflowId;

}
