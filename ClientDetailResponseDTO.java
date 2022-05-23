package com.customer.zokudo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDetailResponseDTO {

    @JsonProperty("id")
    private long clientId;

    @JsonProperty("entityName")
    private String companyName;

    @JsonProperty("email")
    private String email;

}
