package com.customer.zokudo.dto.response;

import lombok.Data;

@Data
public class ProductAPIResponseDto {

    private String code;
    private String message;
    private boolean success;
    private Object details;


}
