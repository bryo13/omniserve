package com.group3.omniserve.model;

import com.group3.omniserve.model.timestampdata.DateAudit;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Billing")
public class Billing  extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private Task task_id;

      @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private User user_id;

       @NotNull
    @Column(name = "Status")
    private String status = "Not paid";

        @NotNull
    @Column(name = "Amount", precision = 10, scale = 2)
    private BigDecimal amount;

         @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

     
    @Column(name = "Created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "Updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Billing() {
        // Default constructor
    }

    public Billing(Task task_id, User user_id, BigDecimal amount, Date date) {
        this.task_id = task_id;
        this.user_id = user_id;
        this.amount = amount;
        this.date = date;
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task_id;
    }

    public void setTask(Task task_id) {
        this.task_id = task_id;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
