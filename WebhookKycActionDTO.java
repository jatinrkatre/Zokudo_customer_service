package com.customer.zokudo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookKycActionDTO {
    private String id;
    private String status;
    private String type;
    private String acton_ref;
}
