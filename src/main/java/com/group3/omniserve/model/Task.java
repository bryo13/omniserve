package com.group3.omniserve.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.group3.omniserve.model.timestampdata.DateAudit;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tasks")
public class Task extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String taskTitle;

    @NotBlank
    private String taskDescription;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private User provider;

    @NotNull
    private BigDecimal budget;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @NotBlank
    private String taskStatus;
    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
  
   

    // Constructors

    public Task() {
        // Default constructor
    }

    public Task(
        String taskTitle,
        String taskDescription,
        User client,
        User provider,
        BigDecimal budget,
        Date deadline,
        String taskStatus
    ) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.client = client;
        this.provider = provider;
        this.budget = budget;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
    }

    // Methods

    public void updateTask(BigDecimal budget, Date deadline, String taskStatus) {
        this.budget = budget;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
    }

    

    
}
