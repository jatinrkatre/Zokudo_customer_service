package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.ConfScoreKarzaWebhookResponse;
import com.customer.zokudo.dto.request.KYCActionDTO;
import com.customer.zokudo.dto.request.KycRequestDTO;
import com.customer.zokudo.dto.request.POIRequestDTO;
import com.customer.zokudo.dto.response.ApiResponse;
import com.customer.zokudo.services.KYCService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1/poapoi")
public class KYCController {

    private final KYCService kycService;

    public KYCController(final KYCService kycService) {
        this.kycService = kycService;
    }

    @ApiOperation(value = "customer poi ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/customerPOI", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            "multipart/form-data"})
    public ApiResponse customerPOI(@PathVariable("programUrl") String programUrl, @ModelAttribute POIRequestDTO poiRequestDTO) {
        return kycService.customerPOI(poiRequestDTO, programUrl);
    }

    @ApiOperation(value = "customer poa ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/customerPOA", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            "multipart/form-data"})
    public ApiResponse customerPOA(@PathVariable("programUrl") String programUrl, @ModelAttribute POIRequestDTO poiRequestDTO) {
        return kycService.customerPoa(poiRequestDTO, programUrl);
    }


    @ApiOperation(value = "customer poa poi kyc request ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "/getPoaPoiKycList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse getPoaPoiKycList(HttpServletRequest request ,@PathVariable("programUrl") String programUrl ) {
        return kycService.getPoaPoiKycList(request.getHeader("page"),programUrl,
                request.getHeader("dateRange"),request.getHeader("mobileNumber"),request.getHeader("docNumber"));
    }

    @ApiOperation(value = "customer poa poi kyc request ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "/viewPoaPoiRequest", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<Object> viewPoaPoiRequest(HttpServletRequest request) {
        return kycService.viewPoaPoiRequest(request.getHeader("kycDetailsId"));
    }

    @ApiOperation(value = "action on kyc request ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/actionOnKycRequest", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse actionOnKycRequest(@PathVariable("programUrl") String programUrl, @RequestBody KYCActionDTO kycActionDTO) {
        return kycService.actionOnKycRequest(kycActionDTO, programUrl);
    }

    @ApiOperation(value = "customer poa poi kyc request ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "/getCustomerKycStatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<Object> getCustomerKycStatus(HttpServletRequest request, @PathVariable("programUrl") String programUrl) {
        return kycService.getCustomerKycStatus(programUrl, request.getHeader("customerHashId"));
    }


    @ApiOperation(value = "karza webhook ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/confScoreUpdateWebhook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse confScoreUpdateWebhook(@PathVariable("programUrl") String programUrl, @RequestBody ConfScoreKarzaWebhookResponse confScore) {
        return kycService.confScoreUpdateWebhook(confScore, programUrl);
    }

}
