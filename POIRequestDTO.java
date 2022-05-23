package com.customer.zokudo.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class POIRequestDTO {

    private String name;
    private String fatherName;
    private String idNumber;
    private MultipartFile docImageFront;
    private MultipartFile docImageBack;
    private MultipartFile aadhaarXml;
    private String customerHashId;
    private String documentType;
    private String dateOfBirth;
    private String address;

}
