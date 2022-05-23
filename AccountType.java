package com.customer.zokudo.entities;

import com.customer.zokudo.enums.AccountCode;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
public class AccountType extends AbstractEntity {

    @Column(nullable = false)
    double balanceLimit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    AccountCode code;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    double dailyLimit;

    @Column(nullable = false)
    double monthlyLimit;

    @Column(nullable = false)
    double yearlyLimit;

    @Column(nullable = false)
    double transactionLimit;

    @Column(nullable = false)
    String description;

    @Transient
//    final static short DEFAULT_ACCOUNT_TYPE_ID = 1;
    final static short MIN_KYC_ACCOUNT_TYPE_ID = 1;
    final static short FULL_KYC_ACCOUNT_TYPE_ID = 2;
    final static short IN_PROCESS_KYC_ACCOUNT_TYPE_ID = 3;

//    public static AccountType getDefault() {
//        AccountType accountType = new AccountType();
//        accountType.setId(DEFAULT_ACCOUNT_TYPE_ID);
//        return accountType;
//    }

    public static AccountType getMinKYC() {
        AccountType accountType = new AccountType();
        accountType.setId(MIN_KYC_ACCOUNT_TYPE_ID);
        return accountType;
    }

    public static AccountType getFullKYC() {
        AccountType accountType = new AccountType();
        accountType.setId(FULL_KYC_ACCOUNT_TYPE_ID);
        return accountType;
    }

    public static AccountType getInProcessKyc() {
        AccountType accountType = new AccountType();
        accountType.setId(IN_PROCESS_KYC_ACCOUNT_TYPE_ID);
        return accountType;
    }

    public double getBalanceLimit() {
        return balanceLimit;
    }

    public void setBalanceLimit(double balanceLimit) {
        this.balanceLimit = balanceLimit;
    }

    public AccountCode getCode() {
        return code;
    }

    public void setCode(AccountCode code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public double getYearlyLimit() {
        return yearlyLimit;
    }

    public void setYearlyLimit(double yearlyLimit) {
        this.yearlyLimit = yearlyLimit;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
