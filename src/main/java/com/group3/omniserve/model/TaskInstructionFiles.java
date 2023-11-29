
package com.group3.omniserve.model;
import javax.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.group3.omniserve.model.timestampdata.DateAudit;
@Entity
@Table(name = "task_instruction_files")
public class TaskInstructionFiles extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String taskFile;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public Long getTaskInstructionFileID() {
        return id;
    }

    public void setTaskInstructionFileID(Long id) {
        this.id = id;
    }

    public String getTaskFile() {
        return taskFile;
    }

    public void setTaskFile(String taskFile) {
        this.taskFile = taskFile;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    // Constructors

    public TaskInstructionFiles() {
        // Default constructor
    }

    public TaskInstructionFiles(String taskFile, Task task) {
        this.taskFile = taskFile;
        this.task = task;
    }

 
   
}
