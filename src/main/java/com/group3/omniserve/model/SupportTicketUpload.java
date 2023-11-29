
package com.group3.omniserve.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SupportTicketUpload")
public class SupportTicketUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SupportTicketID")
    @NotNull(message = "SupportTicket is required")
    private SupportTicket supportTicket;

    @Column(name = "Upload")
    private String upload;

    public SupportTicketUpload() {
        // Default constructor
    }

    public SupportTicketUpload(SupportTicket supportTicket, String upload) {
        this.supportTicket = supportTicket;
        this.upload = upload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupportTicket getSupportTicket() {
        return supportTicket;
    }

    public void setSupportTicket(SupportTicket supportTicket) {
        this.supportTicket = supportTicket;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }
}