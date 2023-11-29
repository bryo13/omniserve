package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.SkillNotFoundException;
import com.group3.omniserve.model.Skill;
import com.group3.omniserve.model.User;
import com.group3.omniserve.model.UserSkills;
import com.group3.omniserve.repository.SkillRepository;
import com.group3.omniserve.repository.UserSkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stephen masaku
 */

@Service
public class UserSkillsService {
    
@Autowired
    private UserSkillsRepository userSkillsRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<UserSkills> getUserSkillsByUserId(Long userId) {
        return userSkillsRepository.findByUserId(userId);
    }

    public void addSkillToUser(User user, Long skillId) {
        Optional<Skill> skillOptional = skillRepository.findById(skillId);
        if (skillOptional.isPresent()) {
            Skill skill = skillOptional.get();
            UserSkills userSkills = new UserSkills(user, skill);
            userSkillsRepository.save(userSkills);
        } else {
            throw new SkillNotFoundException("Skill not found with id: " + skillId);
        }
    }

    public void removeSkillFromUser(User user, Long skillId) {
        List<UserSkills> userSkillsList = userSkillsRepository.findByUserIdAndSkillId(user.getId(), skillId);
        userSkillsList.forEach(userSkillsRepository::delete);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}