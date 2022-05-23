package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.PushNotificationDTO;
import org.codehaus.jettison.json.JSONObject;

public interface NotificationService {

    String sendSMSApi(String to, String text);

    //String sendFromGMail();

    JSONObject pushNotificationToApp(PushNotificationDTO pushNotificationData);
}
