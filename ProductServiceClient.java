package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.response.ClientDetailResponseDTO;

public interface ProductServiceClient {

    APIRequestDto getClientByHashId(String loggedInUserHashId, String programUrl, APIRequestDto apiRequestDto);
}
