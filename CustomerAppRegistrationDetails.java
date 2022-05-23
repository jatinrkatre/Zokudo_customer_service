package com.customer.zokudo.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cust_app_reg_details", indexes = {
        @Index(name = "mobile", columnList = "mobile")
})
public class CustomerAppRegistrationDetails extends  AbstractEntity {

    @Column(name="mobile" , nullable = false, unique = true)
    private String mobile;

    @Column(name="otp" , nullable = false)
    private String otp;

    @Column(name="otp_generation_time" , nullable = false)
    private Date otpGenrationTime;

    @Column(name="device_id" , nullable = false)
    private String deviceId;

    @Column(name="verified" , nullable = false)
    private boolean verified;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Lob
    @Column(name="token")
    private String token;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mobile", referencedColumnName = "mobile")
    private List<CustomerBrandPreference> preferences;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getOtpGenrationTime() {
        return otpGenrationTime;
    }

    public void setOtpGenrationTime(Date otpGenrationTime) {
        this.otpGenrationTime = otpGenrationTime;
    }

    public List<CustomerBrandPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<CustomerBrandPreference> preferences) {
        this.preferences = preferences;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
