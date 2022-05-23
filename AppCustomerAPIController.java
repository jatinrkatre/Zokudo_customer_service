package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.request.CustomerAppRequestDTO;
import com.customer.zokudo.dto.request.KycRequestDTO;
import com.customer.zokudo.dto.response.B2CRegistrationResponseDTO;
import com.customer.zokudo.dto.response.GetCustomerDetailsResponse;
import com.customer.zokudo.services.CustomerService;
import com.customer.zokudo.services.DownloadService;
import com.customer.zokudo.services.KycRequestService;
import com.customer.zokudo.services.MerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("appuser/api/v1")
public class AppCustomerAPIController {

    private final CustomerService customerService;
    private final DownloadService downloadService;
    private final MerchantService merchantService;
    private final KycRequestService kycRequestService;
    private final String PROGRAM_URL ="appuser";

    @Autowired
    public AppCustomerAPIController(final CustomerService customerService,
                                    final DownloadService downloadService,
                                    final MerchantService merchantService,
                                    final KycRequestService kycRequestService) {
        this.customerService = customerService;
        this.downloadService = downloadService;
        this.merchantService = merchantService;
        this.kycRequestService = kycRequestService;
    }

    @ApiOperation(value = "SEND APP SIGNUP/REGISTRATION OTP TO CUSTOMER MOBILE", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/sendOtp")
    public ResponseEntity<?> sendOtp(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.sendSignUpOtp(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "VERIFY CUSTOMER SIGNUP/REGISTRATION OTP", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/verifyCustomerOTP")
    public ResponseEntity<?> verifyCustomerOTP(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.verifyCustomerOTP(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "VERIFY CUSTOMER'S LOGIN CREDENTIALS", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/customerLogin")
    public ResponseEntity<?> customerLogin(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.customerLogin(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "GET CUSTOMER DETAILS REGISTERED WITH RECENT PROGRAM", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomersRecentDetails")
    public ResponseEntity<?> getCustomerDetails(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerDetails(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "B2C CUSTOMER REGISTRATION ON ZOKUDOGPR PROGRAM THROUGH APP", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/b2cCustomerRegistration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object customerRegistration(@RequestBody APIRequestDto apiRequestDto) {
        return customerService.b2cCustomerRegistration(apiRequestDto);
    }

    @ApiOperation(value = "GET B2C CUSTOMER REGISTRATION STATUS, KYC STATUS", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/b2cCustomerRegistrationDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object b2cCustomerRegistrationDetails(@RequestBody APIRequestDto apiRequestDto) {
        return customerService.b2cCustomerRegistrationDetails(apiRequestDto);
    }

    /*@ApiOperation(value = "GENERATE CUSTOMER KYC REQUEST", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/generateKycRequest")
    public ResponseEntity<?> generateKycRequest(@RequestBody @Valid final KycRequestDTO kycRequestDTO) throws ParseException {
        return kycRequestService.generateKycRequest(kycRequestDTO,PROGRAM_URL);
    }*/

    @ApiOperation(value = "VALIDATES CUSTOMER DETAILS BY CustomerHashId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customer/{customerHashId}/validateCustomer")
    public GetCustomerDetailsResponse validateCustomer(
            @PathVariable(value = "customerHashId") @NotBlank(message = "Customer hash id is mandatory") final String customerHashId) {
        return customerService.getDetailsOfCustomer(customerHashId,PROGRAM_URL);
    }

    @ApiOperation(value = "SEND OTP FOR FORGOT PASSWORD CHANGE REQUEST", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/forgotPasswordOTP")
    public ResponseEntity<?> forgotPasswordOTP(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.forgotPasswordOTP(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "RESET FORGOT PASSWORD", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/forgotPassword")
    public ResponseEntity<?> forgotPassword(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.forgotPassword(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "CHANGE PASSWORD", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/changePassword")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.changePassword(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "update customer preference for category_", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateCustomerPref")
    public ResponseEntity<?> updateCustomerPreference(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.updateCustomerPreference(customerAppRequestDTO,PROGRAM_URL);
    }

    @ApiOperation(value = "GET CUSTOMERS BY CUSTOMER MOBILE NUMBER AND PROGRAM PLAN", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomerByMobileAndProgramPlan")
    public ResponseEntity<?> getCustomerByMobileAndProgramPlan(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerByMobileAndProgramPlan(customerAppRequestDTO);
    }

    @ApiOperation(value = "UPDATE CUSTOMER ENTITY", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateEntity")
    public ResponseEntity<?> updateCustomerDetails(HttpServletRequest request, @RequestBody APIRequestDto requestDto) {
        return customerService.updateCustomerAddress(requestDto,PROGRAM_URL);
    }

   /* @ApiOperation(value = "UPDATE CUSTOMER ADDRESS", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateCustomerAddress")
    public ResponseEntity<?> updateCustomerAddress(HttpServletRequest request, @RequestBody APIRequestDto requestDto) {
        return customerService.updateCustomerAddress(requestDto,PROGRAM_URL);
    }*/

}
