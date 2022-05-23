package com.customer.zokudo.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "password_history")
@Entity
@Data
public class PasswordHistory extends AbstractEntity {

    @Column(name="customer_app_reg_id", nullable = false)
    private Long customerAppRegId;

    @Column(name="mobile_no", nullable = false)
    private String mobileNo;

    @Column(name="password", nullable = false)
    private String password;

}
