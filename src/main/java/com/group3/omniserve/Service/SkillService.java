package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.SkillNotFoundException;
import com.group3.omniserve.Exception.SkillAlreadyExistsException;
import com.group3.omniserve.model.Skill;
import com.group3.omniserve.model.User;
import com.group3.omniserve.repository.SkillRepository;
import com.group3.omniserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository, UserRepository userRepository) {
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }

    // Create a new skill
    public Skill createSkill(Skill skill) {
        String skillName = skill.getSkillName();
 

   

        // Check if the User (created by) exists
        User createdBy = userRepository.findById(skill.getCreatedBy().getId())
                .orElseThrow(() -> new IllegalArgumentException("User with the given ID does not exist."));

        // You can add more validation or business logic here

        // Save the skill to the database
        return skillRepository.save(skill);
    }

    // Get all skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get a specific skill by ID
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new SkillNotFoundException("Skill not found with ID: " + id));
    }

    // Update a skill
    public Skill updateSkill(Long id, Skill updatedSkill) {
        Optional<Skill> existingSkillOptional = skillRepository.findById(id);
        if (existingSkillOptional.isEmpty()) {
            throw new SkillNotFoundException("Skill not found with ID: " + id);
        }

        Skill existingSkill = existingSkillOptional.get();
        String updatedSkillName = updatedSkill.getSkillName();

        // Check if a skill with the same name already exists (excluding the current skill)
      
 

   
        existingSkill.setSkillName(updatedSkillName);
        existingSkill.setDescription(updatedSkill.getDescription());

        // You can add more update logic here

        return skillRepository.save(existingSkill);
    }

    // Delete a skill by ID
    public void deleteSkill(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new SkillNotFoundException("Skill not found with ID: " + id);
        }

        skillRepository.deleteById(id);
    }
}
