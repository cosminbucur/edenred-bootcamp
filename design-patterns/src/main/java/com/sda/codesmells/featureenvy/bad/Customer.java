package com.sda.codesmells.featureenvy.bad;

public class Customer {

    private Phone mobilePhone;

    public String getMobilePhoneNumber() {
        return "(" +
                mobilePhone.getAreaCode() + ") " +
                mobilePhone.getNumber();
    }
}