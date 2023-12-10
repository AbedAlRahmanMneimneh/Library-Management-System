package com.library_entity_controllers;

public class Branch {
    private int branchId;
    private String city,street;
    private int phoneNo;

    public Branch(int branchId, String city, String street, int phoneNo) {
        this.branchId = branchId;
        this.city = city;
        this.street = street;
        this.phoneNo = phoneNo;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
