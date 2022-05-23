package com.customer.zokudo.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.zokudo.dto.request.RequestDTO;
import com.customer.zokudo.entities.Brand;
import com.customer.zokudo.services.BrandService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("{programUrl}/api/v1/merchantBrand")
public class BrandController {

	private final BrandService brandService;
	
	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}
	 	
	@ApiOperation(value = "Add Brand", authorizations = {@Authorization(value = "basicAuth")})
	@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/onboardBrand", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> onBoard(HttpServletRequest request, HttpServletResponse
			response, @PathVariable("programUrl") String programUrl, @ModelAttribute RequestDTO dto) {

		return brandService.onBoardBrand(dto);
	}

	@ApiOperation(value = "List Brands", authorizations = {@Authorization(value = "basicAuth")})
	@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/brandList", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<Brand> getBrandList(HttpServletRequest request, HttpServletResponse
			response, @PathVariable("programUrl") String programUrl,@RequestBody RequestDTO dto) {
		return brandService.getBrandList(dto);
	}
	
	@ApiOperation(value = "List Brands without pagination", authorizations = {@Authorization(value = "basicAuth")})
	@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/all/brandList", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> fetchBrandList(HttpServletRequest request, HttpServletResponse
			response, @PathVariable("programUrl") String programUrl) {
		return brandService.fetchBrandList(programUrl);
	}
	
	
	
}
