package com.customer.zokudo.dto.request;

import org.springframework.web.multipart.MultipartFile;

import com.customer.zokudo.enums.BrandCategory;

import lombok.Data;

import java.util.List;

@Data
public class MerchantDTO {

    private String brandId;
    private String merchantId;
    private String merchantFullName;
    private String mobile;
    private String email;
    private boolean hasTerminals;
    private int terminalCount;
    private String terminalList;
    private String mId;

}
