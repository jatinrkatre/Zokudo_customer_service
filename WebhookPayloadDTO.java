package com.customer.zokudo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookPayloadDTO {

    @JsonProperty("kyc_request")
    private WebhookKycRequestDTO kycRequest;

    @JsonProperty("kyc_action")
    private WebhookKycActionDTO kycAction;
}
