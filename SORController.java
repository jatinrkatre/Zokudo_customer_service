package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.SORRequestDto;
import com.customer.zokudo.services.SORService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{programUrl}/api/v1/sor")
public class SORController {

    private final SORService sorService;

    @Autowired
    public SORController(final SORService sorService){
        this.sorService=sorService;
    }

    @ApiOperation(value = "GET customer Incremental", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*", methods = RequestMethod.POST)
    @PostMapping(value="/customerDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getCustomersDetails(@RequestBody SORRequestDto  dto){
        return sorService.getAllCustomersForSor(dto.getStartDate(), dto.getEndDate());
    }
}
