package com.group3.omniserve.repository;

/**
 *
 * @author stephen masaku
 */

import com.group3.omniserve.model.UserSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Long> {

    List<UserSkills> findByUserId(Long userId);

    @Query("SELECT us FROM UserSkills us WHERE us.user.id = :userId AND us.skill.id = :skillId")
    List<UserSkills> findByUserIdAndSkillId(@Param("userId") Long userId, @Param("skillId") Long skillId);
}

