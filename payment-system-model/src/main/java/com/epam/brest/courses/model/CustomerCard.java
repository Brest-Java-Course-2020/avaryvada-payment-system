package com.epam.brest.courses.model;

public class CustomerCard {

    private Integer customerCardId;

    private String customerCardType;

    public Integer getDepartmentId() {
        return customerCardId;
    }

    public CustomerCard setDepartmentId(Integer customerCardId) {
        this.customerCardId = customerCardId;
        return this;
    }

    public String getDepartmentName() {
        return customerCardType;
    }

    public CustomerCard setDepartmentName(String customerCardType) {
        this.customerCardType = customerCardType;
        return this;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + customerCardId +
                ", departmentName='" + customerCardType + '\'' +
                '}';
    }
}