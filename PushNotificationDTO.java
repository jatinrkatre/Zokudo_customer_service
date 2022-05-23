package com.customer.zokudo.dto.request;

import lombok.Data;
import org.codehaus.jettison.json.JSONObject;

@Data
public class PushNotificationDTO {
    String title;
    String message;
    String token;
    JSONObject pushData;
}
