package com.customer.zokudo.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface DownloadService {

    void downloadKycList(HttpServletRequest request, HttpServletResponse response, String programUrl, Map<String, String> requestParams) throws Exception;

    void downloadCustomerList(HttpServletRequest request, HttpServletResponse response, String programUrl, Map<String, String> requestParams) throws Exception;

}
