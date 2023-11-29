package com.group3.omniserve.model;

/**
 *
 * @author stephen masaku
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.group3.omniserve.model.timestampdata.DateAudit;

@Entity
@Table(name = "skills")
public class Skill extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String skillName;

    @NotBlank
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Long getSkillID() {
        return id;
    }

    public void setSkillID(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    // Constructors

    public Skill() {
        // Default constructor
    }

    public Skill(String skillName, String description, User createdBy) {
        this.skillName = skillName;
        this.description = description;
        this.createdBy = createdBy;
    }

    public void setID(Long id) {
   this.id=id;
    }
     public Long getID(){
         return id;
     }

   
}