package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.KycRequestDTO;
import com.customer.zokudo.dto.request.WebhookRequest;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface KycRequestService {

    ResponseEntity<?> generateKycRequest(KycRequestDTO kycRequestDTO,String programUrl) throws ParseException;

    ResponseEntity<?> upgradeKyc(WebhookRequest webhookRequest);
}
