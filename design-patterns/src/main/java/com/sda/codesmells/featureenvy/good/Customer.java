package com.sda.codesmells.featureenvy.good;

public class Customer {

    private Phone mobilePhone;

    public String getMobilePhoneNumber() {
        return mobilePhone.toFormattedString();
    }
}