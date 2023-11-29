
package com.group3.omniserve.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SupportTicketReply")
public class SupportTicketReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Respond")
    @Size(max = 255, message = "Response should not exceed 255 characters")
    private String respond;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "Admin is required")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "SupportTicket is required")
    private SupportTicket supportTicket;

   
    private long parentReply;

    public SupportTicketReply() {
        // Default constructor
    }

    public SupportTicketReply(String respond, User admin, SupportTicket supportTicket, Long parentReply) {
        this.respond = respond;
        this.admin = admin;
        this.supportTicket = supportTicket;
        this.parentReply = parentReply;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public SupportTicket getSupportTicket() {
        return supportTicket;
    }

    public void setSupportTicket(SupportTicket supportTicket) {
        this.supportTicket = supportTicket;
    }

    public Long getParentReply() {
        return parentReply;
    }

    public void setParentReply(Long parentReply) {
        this.parentReply = parentReply;
    }
}
