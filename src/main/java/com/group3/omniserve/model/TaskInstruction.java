
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
@Table(name = "task_instructions")
public class TaskInstruction extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

     // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    // Constructors

    public TaskInstruction() {
        // Default constructor
    }

    public TaskInstruction(Skill skill, Task task) {
        this.skill = skill;
        this.task = task;
    }

  
}
