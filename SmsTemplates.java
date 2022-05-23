package com.customer.zokudo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "sms_templates")
@Data
public class SmsTemplates extends AbstractEntity {
    @Lob
    @Column(name = "template")
    private String template;

    @Column(name = "action", length = 180)
    private String action;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name="is_active")
    private int isActive;
}