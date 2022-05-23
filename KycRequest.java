package com.customer.zokudo.entities;

import com.customer.zokudo.enums.KycStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kyc_request", indexes = {
        @Index(name = "kyc_request_id", columnList = "kyc_request_id", unique = true),
        @Index(name = "customer_id", columnList = "customer_id"),
        @Index(name = "status", columnList = "status")
})
public class KycRequest extends AbstractEntity {

    @Column(name = "kyc_request_id", nullable = false, unique = true)
    private String kycRequestId;

    @Column(name = "reference_id", nullable = false)
    private String referenceId;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "customer_identifier", nullable = false)
    private String customerIdentifier;

    @Column(name = "expire_in_days", nullable = false)
    private String expireInDays;

    @Column(name = "request_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestAt;

    @Column(name = "valid_till", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTill;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KycStatus status;

    @Column(name = "customer_id", nullable = false)
    private long customerId;


    @Column(name = "workflow_id")
    private String workflowId;


    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public void setKycRequestId(String kycRequestId) { this.kycRequestId = kycRequestId; }

    public String getKycRequestId() { return kycRequestId; }

    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    public String getReferenceId() { return referenceId; }

    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getTransactionId() { return transactionId; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerName() { return customerName; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getMobile() { return mobile; }

    public void setCustomerIdentifier(String customerIdentifier) { this.customerIdentifier = customerIdentifier; }

    public String getCustomerIdentifier() { return customerIdentifier; }

    public void setExpireInDays(String expireInDays) { this.expireInDays = expireInDays; }

    public String getExpireInDays() { return expireInDays; }

    public void setRequestAt(Date requestAt) { this.requestAt = requestAt; }

    public Date getRequestAt() { return requestAt; }

    public void setValidTill(Date validTill) { this.validTill = validTill; }

    public Date getValidTill() { return validTill; }

    public void setStatus(KycStatus status) { this.status = status; }

    public KycStatus getStatus() { return status; }

    public void setCustomerId(long customerId) { this.customerId = customerId; }

    public long getCustomerId() { return customerId; }
}
