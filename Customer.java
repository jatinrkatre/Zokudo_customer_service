package com.customer.zokudo.entities;

import com.customer.zokudo.dto.WalletDetails;
import com.customer.zokudo.enums.ProgramPlans;
import com.customer.zokudo.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "customer", indexes = {
        @Index(name = "mobile", columnList = "mobile"),
        @Index(name = "customer_hash_id", columnList = "customer_hash_id"),
        @Index(name = "processor_id", columnList = "processor_id"),
        @Index(name = "program_id", columnList = "program_id"),
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "user_hash_id", columnList = "user_hash_id")
})
public class Customer extends AbstractEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "preferred_name", nullable = false)
    private String preferredName;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "customer_hash_id", nullable = false, unique = true)
    private String customerHashId;

    @Column(name = "processor_id", nullable = false)
    private int processorId;

    @Column(name = "program_id", nullable = false)
    private int programId;

    @Enumerated(EnumType.STRING)
    @Column(name = "program_plan")
    private ProgramPlans programPlan;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_type", nullable = false)
    private Status kycType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, unique = true)
    private CustomerDetails customerDetails;

    @OneToOne
    private AccountType accountType = AccountType.getMinKYC();

    @Transient
    private WalletDetails walletDetails;

    private String zaggleEmployeeId;

    @Column(name = "agent_hash_id")
    private String agentHashId;

    @Column(name = "distributor_hash_id")
    private String distributorHashId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "user_hash_id")
    private String userHashId;

    @Column(name = "fee_deduction", nullable = false)
    private boolean feeDeduction = false;

    public String getAgentHashId() { return agentHashId; }

    public void setAgentHashId(String agentHashId) { this.agentHashId = agentHashId; }

    public String getDistributorHashId() { return distributorHashId; }

    public void setDistributorHashId(String distributorHashId) { this.distributorHashId = distributorHashId; }

    public String getZaggleEmployeeId() { return zaggleEmployeeId; }

    public void setZaggleEmployeeId(String zaggleEmployeeId) { this.zaggleEmployeeId = zaggleEmployeeId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCustomerHashId() {
        return customerHashId;
    }

    public void setCustomerHashId(String customerHashId) {
        this.customerHashId = customerHashId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getKycType() {
        return kycType;
    }

    public void setKycType(Status kycType) {
        this.kycType = kycType;
    }

    public int getProcessorId() {
        return processorId;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public ProgramPlans getProgramPlan() { return programPlan; }

    public void setProgramPlan(ProgramPlans programPlan) { this.programPlan = programPlan; }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public WalletDetails getWalletDetails() {
        return walletDetails;
    }

    public void setWalletDetails(WalletDetails walletDetails) { this.walletDetails = walletDetails; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getUserId() { return userId; }

    public void setUserHashId(String userHashId) { this.userHashId = userHashId; }

    public String getUserHashId() { return userHashId; }

    public void setFeeDeduction(boolean feeDeduction) { this.feeDeduction = feeDeduction; }

    public boolean isFeeDeduction() { return feeDeduction; }
}
