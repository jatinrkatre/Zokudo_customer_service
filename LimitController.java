package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.KycLimitsDTO;
import com.customer.zokudo.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1")
public class LimitController {

    private final CustomerService customerService;

    @Autowired
    public LimitController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Set Kyc limits", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "kyc/setLimits")
    public ResponseEntity<?> setKycLimits(@PathVariable("programUrl") final String programUrl,
                                          @RequestBody @Valid final KycLimitsDTO kycLimitsDto) {
        return customerService.setLimits(kycLimitsDto, programUrl);
    }

    @ApiOperation(value = "Fetch kyc limits", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "kyc/fetchLimits")
    public ResponseEntity<?> fetchCustomerKycLimits(@RequestHeader(value = "page") final int page,
                                                    @RequestHeader(value = "size") final int size,
                                                    @RequestHeader(value = "order") final String order) {
        return new ResponseEntity<>(customerService.fetchCustomerKycLimits(page, size, order), HttpStatus.OK);
    }
}
