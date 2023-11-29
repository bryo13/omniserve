package com.group3.omniserve.model;
import javax.persistence.*;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "OrderRateCards")
public class OrderRateCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "TaskId")
    private Task task;

    @Column(name = "TotalAmount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "ProviderAmount", precision = 10, scale = 2)
    private BigDecimal providerAmount;

    @Column(name = "OptiserveAmount", precision = 10, scale = 2)
    private BigDecimal optiserveAmount;

    public OrderRateCards() {
        // Default constructor
    }

    public OrderRateCards(Task task, BigDecimal totalAmount, BigDecimal providerAmount, BigDecimal optiserveAmount) {
        this.task = task;
        this.totalAmount = totalAmount;
        this.providerAmount = providerAmount;
        this.optiserveAmount = optiserveAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getProviderAmount() {
        return providerAmount;
    }

    public void setProviderAmount(BigDecimal providerAmount) {
        this.providerAmount = providerAmount;
    }

    public BigDecimal getOptiserveAmount() {
        return optiserveAmount;
    }

    public void setOptiserveAmount(BigDecimal optiserveAmount) {
        this.optiserveAmount = optiserveAmount;
    }
}
