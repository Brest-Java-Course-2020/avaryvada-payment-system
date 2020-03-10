package com.epam.brest.courses.model;

import java.math.BigDecimal;
import java.util.Date;

public class Operation {
    private Integer operation_id;
    private Integer customerCard_id;
    private String description;
    private Date operation_date;
    private BigDecimal operation_cost;

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Integer getCustomerCard_id() {
        return customerCard_id;
    }

    public void setCustomerCard_id(Integer customerCard_id) {
        this.customerCard_id = customerCard_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public BigDecimal getOperation_cost() {
        return operation_cost;
    }

    public void setOperation_cost(BigDecimal operation_cost) {
        this.operation_cost = operation_cost;
    }
}
