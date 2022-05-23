package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.ConfScoreKarzaWebhookResponse;
import com.customer.zokudo.dto.request.KYCActionDTO;
import com.customer.zokudo.dto.request.POIRequestDTO;
import com.customer.zokudo.dto.response.ApiResponse;

public interface KYCService {
    ApiResponse customerPOI(POIRequestDTO POIRequestDTO, String programUrl);

    ApiResponse customerPoa(POIRequestDTO poiRequestDTO, String programUrl);

    ApiResponse getPoaPoiKycList(String page, String programUrl, String dateRange, String mobileNumber, String docNumber);

    ApiResponse<Object> viewPoaPoiRequest(String kycDetailsId);

    ApiResponse actionOnKycRequest(KYCActionDTO kycActionDTO, String programUrl);

    ApiResponse<Object> getCustomerKycStatus(String programUrl,String customerHashId);

    ApiResponse confScoreUpdateWebhook(ConfScoreKarzaWebhookResponse confScore, String programUrl);
}
