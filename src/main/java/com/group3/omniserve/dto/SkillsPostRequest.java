package com.group3.omniserve.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.group3.omniserve.model.User;

public class SkillsPostRequest {
    @NotBlank
    private String skillName;

    @NotBlank
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

 

    // Getters and Setters

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
}
