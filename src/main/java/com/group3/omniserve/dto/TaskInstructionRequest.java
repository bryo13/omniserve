package com.group3.omniserve.dto;
import com.group3.omniserve.model.Skill;
import com.group3.omniserve.model.Task;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
public class TaskInstructionRequest {
  @NotNull
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

   
    // Getter and Setter for Skill
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    // Getter and Setter for Task
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}