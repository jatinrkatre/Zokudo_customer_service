package com.customer.zokudo.dto.request;

import lombok.Data;

@Data
public class ConfScoreKarzaWebhookResponse {

    private String requestId;
    private int statusCode;
    private KarzaResponseResult result;
}
