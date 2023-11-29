package com.group3.omniserve.dto;

/**
 *
 * @author stephen masaku
 */


import java.util.List;

public class UserSkillsRequest {
    private Long userId;
    private List<Long> skillIds;

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }
}
