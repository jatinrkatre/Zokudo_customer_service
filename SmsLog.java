package com.customer.zokudo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name = "sms_log")
@Entity
@Data
public class SmsLog extends AbstractEntity {
    @Lob
    @Column(name = "request")
    private String request;

    @Lob
    @Column(name = "response")
    private String response;

    @Column(name = "action")
    private String action;
}