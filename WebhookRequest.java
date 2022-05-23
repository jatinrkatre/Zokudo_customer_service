package com.customer.zokudo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookRequest {

    private List<String> entities;
    private WebhookPayloadDTO payload;

    @JsonProperty("id")
    private String id;

    @JsonProperty("event")
    private String event;
}
