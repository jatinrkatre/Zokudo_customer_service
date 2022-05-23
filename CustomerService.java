package com.customer.zokudo.services;

import java.util.List;

import com.customer.zokudo.dto.request.CustomerAppRequestDTO;
import com.customer.zokudo.dto.request.CustomerHashIdDTO;
import com.customer.zokudo.dto.request.KycLimitsDTO;
import com.customer.zokudo.dto.response.ApiError;
import com.customer.zokudo.dto.response.GetCustomerDetailsResponse;

import com.customer.zokudo.entities.AccountType;
import com.customer.zokudo.entities.Customer;
import org.springframework.data.domain.Page;
import com.customer.zokudo.dto.request.APIRequestDto;
import com.customer.zokudo.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    Object addCustomer(APIRequestDto apiRequestDto , String  programUrl, String loggedInUserHashId);

    Object updateCustomer(APIRequestDto apiRequestDto, String programUrl , String userHashId);

    Object residential(APIRequestDto apiRequestDto, String programUrl, String header);

    ApiResponse<Object> getCustomerById(String programUrl, String header);

    Object getCustomerListByProgramId(String programUrl , String role , String loggedInUserHashId ,String page,String size);

    Object blockUnblockCustomer(APIRequestDto apiRequestDto, String programUrl);

    Object customerCounts(String programUrl , String loggedInUserRole , String programId, String dateRange, String loggedInUserHashId);

    Object getCustomerBasedOnFilter(String programUrl, APIRequestDto apiRequestDto, String role , String loggedInUserHashId);

    Object getKYCBasedOnFilters(String programUrl, APIRequestDto apiRequestDto, String role, String loggedInUserHashId);

    Object getCustomerByProgramId(String programUrl , String role, String loggedInUserHashId);

    Object customerRegistration(APIRequestDto apiRequestDto, String programUrl , String loggedInUserHashId);

    Object getPincodeDetails(String programUrl, String pinCode);

    Object getCustomerGraphData(String programUrl, APIRequestDto apiRequestDto, String role);

    Object getCustomerListByEmail(String programUrl, String searchBy);

    void updateUserHashAndId(int userId, String userHashId, String customerHashId);

    GetCustomerDetailsResponse getDetailsOfCustomer(String customerHashId,String programUrl);

    ResponseEntity<?> getCustomerByCustomerId(long customerId);

    List<Customer> getAllCustomer(String role,String loggedInUserHashId);

    ResponseEntity<?> getAllCustomerByKycType(String kycType);

    ResponseEntity<?> getAllCustomerIdList();

    ResponseEntity<?> getCustomerByMobNumber(CustomerAppRequestDTO customerAppRequestDTO);

    ResponseEntity<?> sendSignUpOtp(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> verifyCustomerOTP(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> getCustomerDetails(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> customerLogin(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> forgotPassword(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> changePassword(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> forgotPasswordOTP(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    void feeDeductionByScheduler();

    ResponseEntity<?> setLimits(KycLimitsDTO kycLimitsDto, String programUrl);

    Page<AccountType> fetchCustomerKycLimits(int page, int size, String order);

    Object createUserDetails(APIRequestDto apiRequestDto, String programUrl , String userHashId);

    ResponseEntity<?> getLendingCustomerDetails(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    ResponseEntity<?> getCustomerByMobileAndProgramPlan(CustomerAppRequestDTO customerAppRequestDTO);

    ResponseEntity<?> getCustomerByMobileAndProgramId(CustomerAppRequestDTO customerAppRequestDTO);

    ResponseEntity<?> getKYCStatus(CustomerAppRequestDTO customerAppRequestDTO);

    ResponseEntity<?> updateKYC(APIRequestDto apiRequestDto, String programUrl);

    ApiResponse<Object> getCustomerByHashId(String header);

    Object updateCustomerDetails(APIRequestDto apiRequestDto, String programUrl , String userHashId);

    ResponseEntity<?> updateCustomerPreference(CustomerAppRequestDTO customerAppRequestDTO,String programUrl);

    Object b2cCustomerRegistration(APIRequestDto apiRequestDto);

    Object b2cCustomerRegistrationDetails(APIRequestDto apiRequestDto);

    ResponseEntity<?> getCustomerIDByMobileNumber(CustomerAppRequestDTO customerAppRequestDTO);

    ResponseEntity<?> getCustomerDetailsForPartnerApi(APIRequestDto customerAppRequestDTO,String programUrl);

    ResponseEntity<?> getCustomerDetailsAndUpdate(APIRequestDto customerAppRequestDTO,String programUrl);


    ResponseEntity<?> sendOtpSms(CustomerAppRequestDTO customerAppRequestDTO, String programUrl);

    ResponseEntity<?> validateOtp(CustomerAppRequestDTO customerAppRequestDTO, String programUrl);

    ResponseEntity<?> updateCustomerAddress(APIRequestDto apiRequestDto, String programUrl);

    ResponseEntity<?> updateIdType(APIRequestDto apiRequestDto, String programUrl);

    ResponseEntity<?> encryptPassword(String programUrl);

    ResponseEntity<?> getAddressCustomerHashId(CustomerHashIdDTO customerHashIdDTO, String programUrl);


}
