package com.customer.zokudo.dto.request;

import lombok.Data;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class APIRequestDto {

    /**
     * @param for registration
     */
    private String firstName;
    private String lastName;
        private String mobile;
        private String email;
    private String preferredName;
    private String mobileCountryCode;
    private String clientCode;

    /**
     * @param for update customer
     */
    private String birthday;
    private String title;
    private String gender;
    private String idType;
    private String idNumber;
    private String countryOfIssue;
    private String idExpiryDate;

    /**
     * @param for residential
     */

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zipCode;


    /**
     * @param for block customer
     */
    private String customerHashId;
    private String status;

    /**
     * @param for fetch customer based on filter
     */
    private String page;
    private String size;
    private String dateRange;
    private String programId;
    private JSONObject programJson;

    /**
     * @param for fetch KYC based on filter
     */
    private String kycStatus;

    /**
     * @param for add customer
     */
    private String hostUrl;
    
    /**
     * @param for adding merchant
     */
    private String brandId;
    private String merchantId;
    private List<String> merchantIdList;
    //private String tId;
    private String merchantFullName;
    //private String terminalFullName;

    private boolean programHasDistributor;
    private String agentHashId;
    private String distributorHashId;
    private String description;
    private String location;
    private String webUrl;
    private double minPrice;
    private double maxPrice;
    private MultipartFile categoryLogo1;
    private MultipartFile categoryLogo2;
    private MultipartFile categoryLogo3;
    private MultipartFile brandLogo;
    private MultipartFile offerLogo;
    private List<TerminalDTO> terminalList;
    private boolean hasTerminals;
    private int terminalCount;
    
    private String mid;
    private String programType;
    private String programHashId;

}
