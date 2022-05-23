package com.customer.zokudo.services;

import com.customer.zokudo.entities.Brand;
import com.customer.zokudo.entities.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.customer.zokudo.dto.request.RequestDTO;

import java.util.List;
import java.util.Map;

public interface BrandService {

	ResponseEntity<?> onBoardBrand(RequestDTO dto);

	Page<Brand> getBrandList(RequestDTO dto);

	List<Brand> fetchBrandList(String programUrl);
}
