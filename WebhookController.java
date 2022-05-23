package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.WebhookRequest;
import com.customer.zokudo.dto.response.ApiError;
import com.customer.zokudo.services.KycRequestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class WebhookController {

    private final KycRequestService kycRequestService;

    @Autowired
    public WebhookController(final KycRequestService kycRequestService) {
        this.kycRequestService = kycRequestService;
    }

    @ApiOperation(value = "Authorize a transaction", authorizations = {@Authorization(value = "basicAuth")})
    @PostMapping(value = "/kyc/notification", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> webhookNotification(@Valid @RequestBody final WebhookRequest webhookRequest) {
        return kycRequestService.upgradeKyc(webhookRequest);
    }
}
