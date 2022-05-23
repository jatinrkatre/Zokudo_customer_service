package com.customer.zokudo.controllers;

import com.customer.zokudo.dto.request.BulkReportRequestDTO;
import com.customer.zokudo.dto.request.BulkUploadDto;
import com.customer.zokudo.dto.response.ApiResponse;
import com.customer.zokudo.exceptions.BizException;
import com.customer.zokudo.services.bulk.BulkUploadInf;
import com.customer.zokudo.services.bulkdownload.DownloadInf;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("{programUrl}/api/v1")
public class BulkOperationController {

    private final BulkUploadInf bulkUploadInf;
    private final DownloadInf downloadInf;

    public BulkOperationController(final BulkUploadInf bulkUploadInf, DownloadInf downloadInf) {
        this.bulkUploadInf = bulkUploadInf;
        this.downloadInf = downloadInf;
    }

    @ApiOperation(value = "Bulk upload for registration.", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", methods = RequestMethod.POST, origins = {"*"})
    @PostMapping(value = "/bulkRegister", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            "multipart/form-data"})
    public ResponseEntity<?> bulkRegister(HttpServletRequest request, @ModelAttribute BulkUploadDto bulkUploadDto,
                                          @PathVariable("programUrl") String programUrl) {
        return new ResponseEntity<ApiResponse>(bulkUploadInf.bulkUpload(request, bulkUploadDto, programUrl), HttpStatus.OK);
    }

    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", methods = RequestMethod.POST, origins = {"*"})
    @PostMapping(value = "/processBulkRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processBulkRegister(HttpServletRequest request, @RequestBody BulkUploadDto bulkUploadDto,
                                                 @PathVariable("programUrl") String programUrl) {
//        return new ResponseEntity<ApiResponse>(bulkUploadInf.processBulkRegister(bulkUploadDto, programUrl), HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(bulkUploadInf.processBulkRegister(bulkUploadDto, programUrl, request.getHeader("loggedInUserHashId")), HttpStatus.OK);
    }

    @ApiOperation(value = "Detailed Customer Register process report with failure reason", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/bulkReport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getBulkReport(HttpServletRequest request, HttpServletResponse response, @RequestBody BulkReportRequestDTO bulkReportDto, @PathVariable("programUrl") String programUrl) {
        return bulkUploadInf.getBulkReport(bulkReportDto, programUrl, request.getHeader("role"), request.getHeader("page"), request.getHeader("size"),request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "Upload summary for processed success and failure record count", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value = "/bulkUploadReport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object bulkUploadReport(HttpServletRequest request, HttpServletResponse response, @PathVariable("programUrl") String programUrl) {
        return bulkUploadInf.bulkUploadReport(programUrl, request.getHeader("role"), request.getHeader("page"), request.getHeader("size"),
                request.getHeader("dateRange"),request.getHeader("loggedInUserHashId"));
    }

    @ApiOperation(value = "Download bulk Customer report List", authorizations = {@Authorization(value = "basicAuth")})
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = {"*"}, methods = RequestMethod.GET)
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void downloadReport(HttpServletRequest request, HttpServletResponse response,@RequestParam final Map<String, String> requestParams,@PathVariable("programUrl") String programUrl) throws Exception {
        try {
            downloadInf.downloadReport(response,requestParams,programUrl);
        } catch (BizException e) {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    


}
