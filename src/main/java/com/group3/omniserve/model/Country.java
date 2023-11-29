package com.group3.omniserve.model;

/**
 *
 * @author stephen masaku
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.group3.omniserve.model.timestampdata.DateAudit;
@Entity
@Table(name = "countries")
public class Country extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

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

    // Constructors

    public Country() {
        // Default constructor
    }

    public Country(String name, String countryCode, String currency, String isoCodes, User createdBy) {
        this.name = name;
        this.countryCode = countryCode;
        this.currency = currency;
        this.isoCodes = isoCodes;
        this.createdBy = createdBy;
    }


    
}