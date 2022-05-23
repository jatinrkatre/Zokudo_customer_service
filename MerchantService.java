package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.request.MerchantDTO;
import com.customer.zokudo.dto.response.ApiResponse;
import com.customer.zokudo.entities.Merchant;
import com.customer.zokudo.entities.MerchantHasTIDs;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MerchantService {

    ResponseEntity<?> createMerchant(MerchantDTO apiRequestDto, String programUrl);

    Page<Merchant> getMerchantList(APIRequestDto dto);

    Map<String,Page<Merchant>> getMerchantListOnFilters(APIRequestDto apiRequestDto);

    ApiResponse<Object> checkMidAndTid(APIRequestDto apiRequestDto);

    ResponseEntity<?> fetchMerchantList();

    ResponseEntity<?> fetchTerminalListByMid(String mId);

    ResponseEntity<?> findByMerchantId(String merchantId);

    ResponseEntity<?> fetchMerchantBymid(String mid);

    ResponseEntity<?> fetchMerchantByBrandIdAndMid(String brandId, String merchantId);

	ResponseEntity<?> editMerchantDetails(MerchantDTO dto);
	
	List<Merchant> fetchMerchantByBrandID(String brandId);

    List<Merchant> fetchListOfMerchantByBrandIdAndMids(String brandId, List<String> merchantIdList);
}
