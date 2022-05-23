package com.customer.zokudo.dto.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.customer.zokudo.enums.BrandCategory;

import lombok.Data;

@Data
public class RequestDTO {
	
	 private String brandName;
	 private String brandId;
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
	 private List<BrandCategory> brandCategory;
	 
	 //For filters
	 private String dateRange;
	 private String page;
	 private String size;

}
