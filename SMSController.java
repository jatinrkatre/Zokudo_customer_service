package com.customer.zokudo.controllers;

import com.customer.zokudo.services.NotificationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class SMSController {

    private NotificationService notificationService;

    @Autowired
    public SMSController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @ApiOperation(value = "Send SMS by mobile and text", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "/sms/send")
    public ResponseEntity<?> fetchWalletLimits(HttpServletRequest request) {
        return new ResponseEntity<>(notificationService.sendSMSApi(request.getParameter("mobile"), request.getParameter("text")), HttpStatus.OK);
    }

}
