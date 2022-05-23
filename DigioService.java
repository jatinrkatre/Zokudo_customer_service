package com.customer.zokudo.services;

import com.customer.zokudo.dto.request.DigioKycDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

public interface DigioService {

    void manageApproval(String status, String entityId);

    void DownloadDigiokycdetailbyDate(String Daterange);

    ResponseEntity<?> downloadDigiokycdetailbyKid(DigioKycDTO kid, HttpServletResponse response);

	ResponseEntity<?> downloadKycMediaBatch(DigioKycDTO digioKycDTO,HttpServletResponse response);

}
