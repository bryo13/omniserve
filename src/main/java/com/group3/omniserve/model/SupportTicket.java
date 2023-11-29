
package com.group3.omniserve.model;

import com.group3.omniserve.model.timestampdata.DateAudit;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "SupportTicket")
public class SupportTicket extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id") // 
    @NotNull(message = "User is required")
    private User user_id;

    @Column(name = "priority")
    @NotBlank(message = "Priority is required")
    private String priority;

    @Column(name = "type")
    @NotBlank(message = "Type is required")
    private String type;

    @Column(name = "message")
    @NotBlank(message = "Message is required")
    private String message;

    @Column(name = "status")
    @NotBlank(message = "Status is required")
    private String status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    public SupportTicket() {
        // Default constructor
    }

    public SupportTicket(User user_id, String priority, String type, String message, String status) {
        this.user_id = user_id;
        this.priority = priority;
        this.type = type;
        this.message = message;
        this.status = status;
        this.created_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user_id) {
        this.user_id = user_id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
