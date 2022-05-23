package com.customer.zokudo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookKycRequestDTO {
    private String id;
    private String status;
    private String reference_id;
    private String transaction_id;
}
