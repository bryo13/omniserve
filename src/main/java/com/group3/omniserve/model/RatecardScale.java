package com.group3.omniserve.model;
import javax.persistence.*;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "RatecardScale")
public class RatecardScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ProviderPercentage", precision = 5, scale = 2)
    private BigDecimal providerPercentage;

    @Column(name = "CompanyPercentage", precision = 5, scale = 2)
    private BigDecimal companyPercentage;

    public RatecardScale() {
        // Default constructor
    }

    public RatecardScale(BigDecimal providerPercentage, BigDecimal companyPercentage) {
        this.providerPercentage = providerPercentage;
        this.companyPercentage = companyPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getProviderPercentage() {
        return providerPercentage;
    }

    public void setProviderPercentage(BigDecimal providerPercentage) {
        this.providerPercentage = providerPercentage;
    }

    public BigDecimal getCompanyPercentage() {
        return companyPercentage;
    }

    public void setCompanyPercentage(BigDecimal companyPercentage) {
        this.companyPercentage = companyPercentage;
    }
}

