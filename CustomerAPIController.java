package com.customer.zokudo.controllers;


import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

import com.customer.zokudo.dto.response.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.request.CustomerAppRequestDTO;
import com.customer.zokudo.dto.request.CustomerHashIdDTO;
import com.customer.zokudo.dto.response.ApiResponse;
import com.customer.zokudo.dto.response.CustomerAddressResponse;
import com.customer.zokudo.dto.response.GetCustomerDetailsResponse;
import com.customer.zokudo.entities.Customer;
import com.customer.zokudo.exceptions.BizException;
import com.customer.zokudo.services.CustomerService;
import com.customer.zokudo.services.DownloadService;
import com.customer.zokudo.services.MerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1")
public class CustomerAPIController {

    private final CustomerService customerService;
    private final DownloadService downloadService;
    private final MerchantService merchantService;

    @Autowired
    public CustomerAPIController(final CustomerService customerService,
                                 final DownloadService downloadService,
                                 final MerchantService merchantService) {
        this.customerService = customerService;
        this.downloadService = downloadService;
        this.merchantService = merchantService;
    }

    @ApiOperation(value = "To register new customer", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object addCustomer(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable("programUrl") String programUrl, @RequestBody APIRequestDto apiRequestDto) {
        return customerService.addCustomer(apiRequestDto, programUrl, request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "To update existing customer", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PutMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCustomer(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                 @RequestBody APIRequestDto apiRequestDto) {
        return customerService.updateCustomer(apiRequestDto, programUrl, request.getHeader("User-Hash-id"));
    }

    @ApiOperation(value = "To update residential", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/residential", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object residential(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                              @RequestBody APIRequestDto apiRequestDto) {
        return customerService.residential(apiRequestDto, programUrl, request.getHeader("User-Hash-id"));
    }

    @ApiOperation(value = "Customer registration", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/customerRegistration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object customerRegistration(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                       @RequestBody APIRequestDto apiRequestDto) {
        return customerService.customerRegistration(apiRequestDto, programUrl, request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "Get Customer By Id", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customerById", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getCustomerById(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
        return customerService.getCustomerById(programUrl, request.getHeader("User-Hash-Id"));
    }


    @ApiOperation(value = "Fetch Customer By Program", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/fetchCustomerByProgram", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getCustomerByProgramId(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
//        return customerService.getCustomerListByProgramId(programUrl, request.getHeader("role"), request.getHeader("page"), request.getHeader("size"));
        return customerService.getCustomerListByProgramId(programUrl, request.getHeader("role") , request.getHeader("loggedInUserHashId"), request.getHeader("page"), request.getHeader("size"));
    }

    @ApiOperation(value = "Fetch Customer list By Program", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/fetchCustomerListByProgram", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getCustomerListByProgramId(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
        return customerService.getCustomerByProgramId(programUrl,request.getHeader("role") , request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "Fetch KYC List Based on Filters", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/kycListBasedOnFilter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getKYCBasedOnFilters(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                       @RequestBody APIRequestDto apiRequestDto) {
        return customerService.getKYCBasedOnFilters(programUrl, apiRequestDto, request.getHeader("role"), request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "To block or unblock customer", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/blockUnblockCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object blockUnblockCustomer(HttpServletRequest request, HttpServletResponse response,
                                       @PathVariable("programUrl") String programUrl, @RequestBody APIRequestDto apiRequestDto) {
        return customerService.blockUnblockCustomer(apiRequestDto, programUrl);
    }

    @ApiOperation(value = "Customer Counts ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customerCounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object customerCounts(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
        return customerService.customerCounts(programUrl, request.getHeader("loggedInUserRole"), request.getHeader("programId"), request.getHeader("dateRange"), request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "Fetch Customer List Based on Filters", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/customerListBasedOnFilter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object FetchCustomerBasedOnFilters(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                              @RequestBody APIRequestDto apiRequestDto) {
//        return customerService.getCustomerBasedOnFilter(programUrl, apiRequestDto, request.getHeader("role"));
        return customerService.getCustomerBasedOnFilter(programUrl, apiRequestDto, request.getHeader("role"),request.getHeader("loggedInUserHashId"));
    }


    @ApiOperation(value = "Download Customer List", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"}, methods = RequestMethod.GET)
    @GetMapping(value = "/downloadCustomer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void DownloadCustomerList(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                     @RequestParam final Map<String, String> requestParams) throws Exception {
        try {
            downloadService.downloadCustomerList(request, response, programUrl, requestParams);
        } catch (BizException e) {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    @ApiOperation(value = "download Kyc List", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping(value = "/downloadKycList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void downloadKycList(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable("programUrl") String programUrl, @RequestParam final Map<String, String> requestParams) throws Exception {
        try {
            downloadService.downloadKycList(request, response, programUrl, requestParams);
        } catch (BizException e) {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    @ApiOperation(value = "get state and city by pincode", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping(value = "/checkPincode", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getPincodeDetails(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable("programUrl") String programUrl) {
        return customerService.getPincodeDetails(programUrl, request.getHeader("pincode"));
    }

    @ApiOperation(value = "Get Customer Graph Data", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/getCustomerGraphData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getCustomerGraphData(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                       @RequestBody APIRequestDto apiRequestDto) {
        return customerService.getCustomerGraphData(programUrl, apiRequestDto, request.getHeader("role"));
    }

    @ApiOperation(value = "Fetch Customer By Program and Email or Contact", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/getCustomerByEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getCustomerListByEmail(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
        return customerService.getCustomerListByEmail(programUrl, request.getHeader("searchBy"));
    }

    @ApiOperation(value = "validate Customer details by customerHashId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customer/{customerHashId}/validateCustomer")
    public GetCustomerDetailsResponse validateCustomer(
            @PathVariable(value = "customerHashId") @NotBlank(message = "Customer hash id is mandatory") final String customerHashId,
            @PathVariable("programUrl")final String programUrl) {
        return customerService.getDetailsOfCustomer(customerHashId,programUrl);
    }

    @ApiOperation(value = "get customer by customerId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/getCustomerByCustomerId/{customerId}")
    public ResponseEntity<?> getCustomerByCustomerId(@PathVariable(value = "customerId") final long customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @ApiOperation(value = "Fetch all Customer", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/fetchAllCustomer")
    public List<Customer> getAllCustomer(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl) {
        return customerService.getAllCustomer(request.getHeader("role"),request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "get customer by customerId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customer/{kycType}/getCustomerByKycType")
    public ResponseEntity<?> getCustomerByKycType(@PathVariable(value = "kycType") @NotBlank(message = "KycType id is mandatory") final String kycType) {
        return customerService.getAllCustomerByKycType(kycType);
    }

    @ApiOperation(value = "get customer by customerId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customer/getAllCustomerIdList")
    public ResponseEntity<?> getAllCustomerIdList() {
        return customerService.getAllCustomerIdList();
    }

    @ApiOperation(value = "GET CUSTOMERS BY CUSTOMER MOBILE NUMBER", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/customer/getCustomersByMobNumber")
    public ResponseEntity<?> getCustomerByCustomerId(@RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerByMobNumber(customerAppRequestDTO);
    }

    @ApiOperation(value = "GET CUSTOMERS BY CUSTOMER MOBILE NUMBER AND PROGRAM PLAN", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomerByMobileAndProgramPlan")
    public ResponseEntity<?> getCustomerByMobileAndProgramPlan(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerByMobileAndProgramPlan(customerAppRequestDTO);
    }

    @ApiOperation(value = "GET CUSTOMERS BY CUSTOMER MOBILE NUMBER AND PROGRAM ID for Default and Distributor programPlan", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomerByMobileAndProgramId")
    public ResponseEntity<?> getCustomerByMobileAndProgramId(HttpServletRequest request, @RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerByMobileAndProgramId(customerAppRequestDTO);
    }

    @ApiOperation(value = "To update KYC status", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateKYC", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateKYC(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                              @RequestBody APIRequestDto apiRequestDto) {
        return customerService.updateKYC(apiRequestDto, programUrl);
    }

    @ApiOperation(value = "Get Customer By HashId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/customerByHashId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getCustomerByHashId(HttpServletRequest request, HttpServletResponse
            response) {
        return customerService.getCustomerByHashId(request.getHeader("customerHashId"));
    }

    @ApiOperation(value = "To update existing customer", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PutMapping(value = "/updateCustomerDetail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCustomerDetail(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,
                                       @RequestBody APIRequestDto apiRequestDto) {
        return customerService.updateCustomerDetails(apiRequestDto, programUrl, request.getHeader("User-Hash-id"));
    }

    @ApiOperation(value = "GET CUSTOMER ID BY MOBILE NUMBER", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/customer/byMobileNumber")
    public ResponseEntity<?> getCustomerByMobileNumber(@RequestBody CustomerAppRequestDTO customerAppRequestDTO) {
        return customerService.getCustomerIDByMobileNumber(customerAppRequestDTO);
    }


    // Send otp message by validating program and mobile
    @ApiOperation(value = "SEND OTP MESSAGE BY VALIDATING PROGRAM AND MOBILE", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/sms/send-otp")
    public ResponseEntity<?> sendOtpSms(@RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                        @PathVariable("programUrl") String programUrl) {
        return customerService.sendOtpSms(customerAppRequestDTO, programUrl);
    }

    @ApiOperation(value = "SEND OTP MESSAGE BY VALIDATING PROGRAM AND MOBILE", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/sms/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody CustomerAppRequestDTO customerAppRequestDTO,
                                        @PathVariable("programUrl") String programUrl) {
        return customerService.validateOtp(customerAppRequestDTO, programUrl);
    }

    @ApiOperation(value = "UPDATE CUSTOMER ENTITY", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateEntity")
    public ResponseEntity<?> updateCustomerDetails(HttpServletRequest request, @RequestBody APIRequestDto requestDto,
                                                   @PathVariable("programUrl")String programUrl) {
        return customerService.updateCustomerAddress(requestDto,programUrl);
    }



    @ApiOperation(value = "update Id type", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true",allowedHeaders="*")
    @PutMapping(value="/updateIdType")
    public ResponseEntity<?> updateIdType(@RequestBody APIRequestDto apiRequestDto, @PathVariable("programUrl") String programUrl){
        return customerService.updateIdType(apiRequestDto,programUrl);
    }

    @ApiOperation(value = "MIGRATE CUSTOMER ENCODE PASSWORD CHANGES", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/migration/encrpytPassword")
    public ResponseEntity<?> encryptCustomerPassword(HttpServletRequest request,
                                                   @PathVariable("programUrl")String programUrl) {
        return customerService.encryptPassword(programUrl);
    }
    
    @ApiOperation(value = "GET CUSTOMER ADDRESS BY CUSTOMER HASH ID", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/address/byCustomerHashId")
    public ResponseEntity<?> getAddressCustomerHashId(@RequestBody CustomerHashIdDTO customerHashIdDTO,  HttpServletRequest request,
                                                   @PathVariable("programUrl")String programUrl) {
        return customerService.getAddressCustomerHashId(customerHashIdDTO,programUrl);
    }




}