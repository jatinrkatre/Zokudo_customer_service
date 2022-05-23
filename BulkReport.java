package com.customer.zokudo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "bulk_report")
@Data
public class BulkReport extends AbstractEntity {

    private boolean autobotsStatus;
    private boolean processorStatus;
    private boolean walletCreation;
    private String failureReason;
    private String name;
    private String mobile;
    private String email;
    private String productCode;
    private String programHashId;
    private String fileName;
    private String agentHashId;

    @Lob
    private String requestData;

}
