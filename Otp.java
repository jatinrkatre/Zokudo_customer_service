package com.customer.zokudo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "otp")
@Entity
@Data
public class Otp extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    @Lob
    @Column(name = "message")
    private String message;

    @Column(name = "otp_code", length = 50)
    private String otpCode;

    @Column(name = "mobile", length = 50)
    private String mobile;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "otp_action_type", length = 50)
    private String otpActionType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "expiry_date_time")
    private LocalDateTime expiryDateTime;

}