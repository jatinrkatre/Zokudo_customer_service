package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.CustomerAppRequestDTO;
import com.customer.zokudo.dto.request.KycRequestDTO;
import com.customer.zokudo.dto.response.GetCustomerDetailsResponse;
import com.customer.zokudo.services.CustomerService;
import com.customer.zokudo.services.DownloadService;
import com.customer.zokudo.services.KycRequestService;
import com.customer.zokudo.services.MerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Slf4j
@RestController
//@RequestMapping("lending/appuser/api/v1")
@RequestMapping("{programUrl}/consumable/api/v1")
public class LendingAppCustomerAPIController {

    private final CustomerService customerService;
    private final DownloadService downloadService;
    private final MerchantService merchantService;
    private final KycRequestService kycRequestService;

    @Autowired
    public LendingAppCustomerAPIController(final CustomerService customerService,
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
    public ResponseEntity<?> sendOtp(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                     @PathVariable("programUrl")final String programUrl) {
        return customerService.sendSignUpOtp(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "VERIFY CUSTOMER SIGNUP/REGISTRATION OTP", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/verifyCustomerOTP")
    public ResponseEntity<?> verifyCustomerOTP(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                               @PathVariable("programUrl")final String programUrl) {
        return customerService.verifyCustomerOTP(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "VERIFY CUSTOMER'S LOGIN CREDENTIALS", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/customerLogin")
    public ResponseEntity<?> customerLogin(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                           @PathVariable("programUrl")final String programUrl) {
        return customerService.customerLogin(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "GET CUSTOMER DETAILS REGISTERED WITH RECENT PROGRAM", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomersRecentDetails")
    public ResponseEntity<?> getCustomerDetails(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                                @PathVariable("programUrl")final String programUrl) {
        return customerService.getLendingCustomerDetails(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "GENERATE CUSTOMER KYC REQUEST", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/generateKycRequest")
    public ResponseEntity<?> generateKycRequest(@RequestBody @Valid final KycRequestDTO kycRequestDTO,
                                                @PathVariable("programUrl")final String programUrl) throws ParseException {
        return kycRequestService.generateKycRequest(kycRequestDTO,programUrl);
    }

    @ApiOperation(value = "VALIDATES CUSTOMER DETAILS BY CustomerHashId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customer/{customerHashId}/validateCustomer")
    public GetCustomerDetailsResponse validateCustomer(
            @PathVariable(value = "customerHashId") @NotBlank(message = "Customer hash id is mandatory") final String customerHashId,
            @PathVariable("programUrl")final String programUrl) {
        return customerService.getDetailsOfCustomer(customerHashId,programUrl);
    }

    @ApiOperation(value = "SEND OTP FOR FORGOT PASSWORD CHANGE REQUEST", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/forgotPasswordOTP")
    public ResponseEntity<?> forgotPasswordOTP(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                               @PathVariable("programUrl")final String programUrl) {
        return customerService.forgotPasswordOTP(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "RESET FORGOT PASSWORD", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/forgotPassword")
    public ResponseEntity<?> forgotPassword(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                            @PathVariable("programUrl")final String programUrl) {
        return customerService.forgotPassword(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "CHANGE PASSWORD", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/changePassword")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                            @PathVariable("programUrl")final String programUrl) {
        return customerService.changePassword(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "GET CUSTOMER KYC STATUS BY MOBILE", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getKYCStatus")
    public ResponseEntity<?> getKYCStatus(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getKYCStatus(customerAppRequestDTO);
    }


}
