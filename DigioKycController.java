package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.DigioKycDTO;
import com.customer.zokudo.services.DigioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1/digioKyc")
public class DigioKycController {

   private final DigioService digioService;

   public DigioKycController(DigioService digioService) {
      this.digioService = digioService;
   }

   @ApiOperation(value = "get kyc media by digio", authorizations = {@Authorization(value = "basicAuth")})
   @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
   @PostMapping(value = "/getkycMedia", consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> getKycMedia(@RequestBody DigioKycDTO digioKycDTO, HttpServletResponse response){
      return digioService.downloadDigiokycdetailbyKid(digioKycDTO,response);
   }
   
   @ApiOperation(value = "get kyc media batch based on date range by digio", authorizations = {@Authorization(value = "basicAuth")})
   @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
   @PostMapping(value = "/getKycMediaBatch", consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> getKycMediaBatch(@RequestBody DigioKycDTO digioKycDTO, HttpServletResponse response) {
       return digioService.downloadKycMediaBatch(digioKycDTO,response);
   }

}
