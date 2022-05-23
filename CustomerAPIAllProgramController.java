package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.request.CustomerAppRequestDTO;
import com.customer.zokudo.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("{programUrl}/partner/api/v1")
public class CustomerAPIAllProgramController {

    private final CustomerService customerService;

    @Autowired
    public CustomerAPIAllProgramController(final CustomerService customerService){
     this.customerService = customerService;
}


    @ApiOperation(value = "GET CUSTOMER DETAILS REGISTERED WITH RECENT PROGRAM", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/getCustomersRecentDetails")
    public ResponseEntity<?> getCustomerDetails(HttpServletRequest request, @RequestBody APIRequestDto customerAppRequestDTO,
                                                @PathVariable("programUrl")String programUrl) {
        return customerService.getCustomerDetailsForPartnerApi(customerAppRequestDTO,programUrl);
    }

    @ApiOperation(value = "GET CUSTOMER DETAILS AND UPDATE CHANGE ADDRESS & EMAIL", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/updateRecentCustomerDetail")
    public ResponseEntity<?> getCustomerDetailsAndUpdate(HttpServletRequest request, @RequestBody APIRequestDto customerAppRequestDTO,
                                                         @PathVariable("programUrl")String programUrl) {
        return customerService.getCustomerDetailsAndUpdate(customerAppRequestDTO,programUrl);
    }

}
