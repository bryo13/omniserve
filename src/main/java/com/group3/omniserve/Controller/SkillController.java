package com.group3.omniserve.Controller;

import com.group3.omniserve.Service.SkillService;
import com.group3.omniserve.model.Skill;
import com.group3.omniserve.dto.SkillsPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // Create a new skill
    @PostMapping
    public Skill createSkill(@Valid @RequestBody SkillsPostRequest skillsPostRequest) {
        Skill skill = new Skill();
    skill.setSkillName(skillsPostRequest.getSkillName());
    skill.setDescription(skillsPostRequest.getDescription());
    skill.setCreatedBy(skillsPostRequest.getCreatedBy());
    return skillService.createSkill(skill);
       
    }

      // Get all skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get a specific skill by ID
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    // Update a skill
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @Valid @RequestBody SkillsPostRequest skillsPostRequest) {
        Skill skill = new Skill();
        skill.setSkillName(skillsPostRequest.getSkillName());
        skill.setDescription(skillsPostRequest.getDescription());
        skill.setCreatedBy(skillsPostRequest.getCreatedBy());
        return skillService.updateSkill(id, skill);
    }

    // Delete a skill by ID
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}