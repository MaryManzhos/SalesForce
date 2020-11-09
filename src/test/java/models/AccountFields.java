package models;

import java.util.List;

public class AccountFields {
    String accountName;
    String type;
    String website;
    String description;
    String parentAccount;
    String phone;
    String industry;
    String employees;

    List<String> billingAddressInformation;
    List<String> shippingAddressInformation;

    /*String billingStreet;
    String billingCity;
    String billingStateProvince;
    String billingZipPostalCode;
    String billingCountry;
    String shippingStreet;
    String shippingCity;
    String shippingStateProvince;
    String shippingZipPostalCode;
    String shippingCountry;*/

    public AccountFields() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public List<String> getBillingAddressInformation() {
        return billingAddressInformation;
    }

    public void setBillingAddressInformation(List<String> billingAddressInformation) {
        this.billingAddressInformation = billingAddressInformation;
    }

    public List<String> getShippingAddressInformation() {
        return shippingAddressInformation;
    }

    public void setShippingAddressInformation(List<String> shippingAddressInformation) {
        this.shippingAddressInformation = shippingAddressInformation;
    }
}
