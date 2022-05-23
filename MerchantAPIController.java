package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.request.MerchantDTO;
import com.customer.zokudo.entities.Merchant;
import com.customer.zokudo.services.MerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1")
public class MerchantAPIController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantAPIController(final MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @ApiOperation(value = "Validate MID TID", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/validateMidTid", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> validateMidTid(HttpServletRequest request, HttpServletResponse
            response, @RequestBody APIRequestDto apiRequestDto) {
        return new ResponseEntity<>(merchantService.checkMidAndTid(apiRequestDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Add merchant", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/addMerchant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMerchant(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl, @ModelAttribute MerchantDTO apiRequestDto) {
        return merchantService.createMerchant(apiRequestDto, programUrl);
    }

    @ApiOperation(value = "List merchant", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/merchantList", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Page<Merchant> getMerchantList(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,@RequestBody APIRequestDto dto) {
        return merchantService.getMerchantList(dto);
    }

    @ApiOperation(value = "list merchant on filters", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/merchantListOnfilter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Page<Merchant>> getMerchantListOnfilters(HttpServletRequest request, HttpServletResponse
            response, @PathVariable("programUrl") String programUrl,@RequestBody APIRequestDto apiRequestDto) {
        return merchantService.getMerchantListOnFilters(apiRequestDto);
    }

    @ApiOperation(value = "Fetch Merchant List", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "merchantListWithoutPagination")
    public ResponseEntity<?> fetchMerchantList() {
        return merchantService.fetchMerchantList();
    }

    @ApiOperation(value = "Fetch Terminal List", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "merchant/{mId}/terminalList")
    public ResponseEntity<?> fetchTerminalList(@PathVariable(value = "mId") @NotEmpty(message = "mId can't be null") String mId) {
        return merchantService.fetchTerminalListByMid(mId);
    }

    @ApiOperation(value = "Fetch Merchant by merchantId and terminalId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "merchant/{mId}/terminal/{tId}/findMerchant")
    public ResponseEntity<?> findMerchant(@PathVariable(value = "mId") @NotEmpty(message = "mId can't be null") String mId) {
        return merchantService.findByMerchantId(mId);
    }

    @ApiOperation(value = "Fetch Merchant by merchantId and terminalId", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "/findMerchant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findMerchant(HttpServletRequest request, HttpServletResponse
            response, @RequestBody APIRequestDto apiRequestDto) {
        return merchantService.findByMerchantId(apiRequestDto.getMerchantId());
    }

    @ApiOperation(value = "Fetch Merchant Details by Mid", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "merchant/{mId}/fetchMerchantByMid")
    public ResponseEntity<?> fetchMerchantByMid(@PathVariable(value = "mId") @NotEmpty(message = "mId can't be null") String mId) {
        return merchantService.fetchMerchantBymid(mId);
    }

    @ApiOperation(value = "Fetch Merchant Details by brandId and Mid", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "merchant/fetchMerchantByBrandIdAndMid")
    public ResponseEntity<?> fetchMerchantBybrandIdAndMid(@RequestBody APIRequestDto apiRequestDto) {
        return merchantService.fetchMerchantByBrandIdAndMid(apiRequestDto.getBrandId(), apiRequestDto.getMerchantId());
    }

    @ApiOperation(value = "Fetch list of Merchant Details by brandId and Mids", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value = "merchant/fetchListOfMerchantByBrandIdAndMids")
    public List<Merchant> fetchListOfMerchantByBrandIdAndMids(@RequestBody APIRequestDto apiRequestDto) {
        return merchantService.fetchListOfMerchantByBrandIdAndMids(apiRequestDto.getBrandId(), apiRequestDto.getMerchantIdList());
    }
    
    @ApiOperation(value = "Edit Merchant Details by Mid", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @PostMapping(value="merchant/edit")
    public ResponseEntity<?> editMerchantDetails(@ModelAttribute MerchantDTO dto){
    	return merchantService.editMerchantDetails(dto);
    }
    
    @ApiOperation(value = "Fetch Merchant Details by Brand ID ", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"})
    @GetMapping(value = "merchant/{brandId}/fetchMerchantByBrandId")
    public List<Merchant> fetchMerchantByBrandID(@PathVariable(value = "brandId") @NotEmpty(message = "brandId can't be null") String brandId) {
        return merchantService.fetchMerchantByBrandID(brandId);
    }
    
    
}
