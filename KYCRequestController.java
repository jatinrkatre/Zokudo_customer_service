package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.KycRequestDTO;
import com.customer.zokudo.services.KycRequestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("{programUrl}/api/v1")
public class KYCRequestController {

    private final KycRequestService kycRequestService;

    @Autowired
    public KYCRequestController(KycRequestService kycRequestService){
        this.kycRequestService = kycRequestService;
    }

    @ApiOperation(value = "GENERATE CUSTOMER KYC REQUEST", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/generateKycRequest")
    public ResponseEntity<?> generateKycRequest(@RequestBody @Valid final KycRequestDTO kycRequestDTO,
                                                @PathVariable("programUrl")String programUrl) throws ParseException {
        return kycRequestService.generateKycRequest(kycRequestDTO,programUrl);
    }
}
