package com.group3.omniserve.dto;
import com.group3.omniserve.model.Task;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class TaskInstructionFilesRequest {
      @NotBlank
    private String taskFile;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

   

    // Getter and Setter for taskFile
    public String getTaskFile() {
        return taskFile;
    }

    public void setTaskFile(String taskFile) {
        this.taskFile = taskFile;
    }

    // Getter and Setter for task
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}