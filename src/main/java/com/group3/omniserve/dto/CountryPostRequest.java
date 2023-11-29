package com.group3.omniserve.dto;
import com.group3.omniserve.model.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

public class CountryPostRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String countryCode;

    @NotBlank
    private String currency;

    @NotBlank
    private String isoCodes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIsoCodes() {
        return isoCodes;
    }

    public void setIsoCodes(String isoCodes) {
        this.isoCodes = isoCodes;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

  
}
