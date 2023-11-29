package com.group3.omniserve.dto;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TaskPostRequest {
    private List<TaskInstructionRequest> taskInstructions;
    private List<TaskInstructionFilesRequest> taskInstructionFiles;
    
    private String taskTitle;
    private String taskDescription;
    private Long clientId;
    private BigDecimal budget;
    private Date deadline;

    public List<TaskInstructionRequest> getTaskInstructions() {
        return taskInstructions;
    }

    public void setTaskInstructions(List<TaskInstructionRequest> taskInstructions) {
        this.taskInstructions = taskInstructions;
    }

    public List<TaskInstructionFilesRequest> getTaskInstructionFiles() {
        return taskInstructionFiles;
    }

    public void setTaskInstructionFiles(List<TaskInstructionFilesRequest> taskInstructionFiles) {
        this.taskInstructionFiles = taskInstructionFiles;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
}
