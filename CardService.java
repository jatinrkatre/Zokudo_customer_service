package com.customer.zokudo.services;

import com.customer.zokudo.dto.response.ApiResponse;
import org.codehaus.jettison.json.JSONObject;

public interface CardService {

    JSONObject createB2cCard(String mobile);


}
