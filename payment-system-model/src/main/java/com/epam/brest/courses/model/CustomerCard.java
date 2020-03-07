package com.epam.brest.courses.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CustomerCard {

    private Integer customerCardId;
    private String customerCardType;
    private Integer customerCardNumber;
    private BigDecimal customerCardBalance;
    private BigDecimal customerCardExpense;

    public Integer getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(Integer customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public BigDecimal getCustomerCardBalance() {
        return customerCardBalance;
    }

    public void setCustomerCardBalance(BigDecimal customerCardBalance) {
        this.customerCardBalance = customerCardBalance;
    }

    public BigDecimal getCustomerCardExpense() {
        return customerCardExpense;
    }

    public void setCustomerCardExpense(BigDecimal customerCardExpense) {
        this.customerCardExpense = customerCardExpense;
    }

    public Boolean getCustomerCardBlock() {
        return customerCardBlock;
    }

    public void setCustomerCardBlock(Boolean customerCardBlock) {
        this.customerCardBlock = customerCardBlock;
    }

    private Boolean customerCardBlock;

    public Integer getCustomerCardId() {
        return customerCardId;
    }

    public CustomerCard setCustomerCardId(Integer customerCardId) {
        this.customerCardId = customerCardId;
        return this;
    }

    public String getCustomerCardType() {
        return customerCardType;
    }

    public CustomerCard setCustomerCardType(String customerCardType) {
        this.customerCardType = customerCardType;
        return this;
    }

    @Override
    public String toString() {
        return "CustomerCard{" +
                "customerCardId=" + customerCardId +
                ", customerCardType='" + customerCardType + '\'' +
                ", customerCardNumber=" + customerCardNumber +
                ", customerCardBalance=" + customerCardBalance +
                ", customerCardAmount=" + customerCardExpense +
                ", customerCardBlock=" + customerCardBlock +
                '}';
    }
}