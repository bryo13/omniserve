package com.group3.omniserve.Controller;

import com.group3.omniserve.Exception.SkillNotFoundException;
import com.group3.omniserve.Exception.UserNotFoundException;
import com.group3.omniserve.Service.UserService;
import com.group3.omniserve.Service.UserSkillsService;
import com.group3.omniserve.dto.UserSkillsRequest;
import com.group3.omniserve.model.Skill;
import com.group3.omniserve.model.User;
import com.group3.omniserve.model.UserSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skills")
public class UserSkillsController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSkillsService userSkillsService;

    @GetMapping("/allSkills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        try {
            List<Skill> allSkills = userSkillsService.getAllSkills();
            return ResponseEntity.ok(allSkills);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mySkills/{userId}")
    public ResponseEntity<List<Skill>> getUserSkills(@PathVariable Long userId) {
        try {
            User user = userService.getUserById(userId);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            List<Skill> userSkills = userSkillsService.getUserSkillsByUserId(userId)
                    .stream()
                    .map(UserSkills::getSkill)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(userSkills);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/addSkills/{userId}")
    public ResponseEntity<String> addSkillsToUser(@PathVariable Long userId, @RequestBody UserSkillsRequest userSkillsRequest) {
        try {
            User user = userService.getUserById(userId);
            if (user == null) {
              throw new UserNotFoundException("User not found with ID: " + userId);
            }

            List<Long> skillIds = userSkillsRequest.getSkillIds();

            List<UserSkills> userSkillsList = userSkillsService.getUserSkillsByUserId(userId);
            if (userSkillsList.size() + skillIds.size() > 5) {
                return ResponseEntity.badRequest().body("A user can have no more than 5 skills.");
            }

            for (Long skillId : skillIds) {
                userSkillsService.addSkillToUser(user, skillId);
            }

            return ResponseEntity.ok("Skills added successfully.");
        } catch (SkillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/removeSkills/{userId}")
    public ResponseEntity<String> removeSkillsFromUser(@PathVariable Long userId, @RequestBody UserSkillsRequest userSkillsRequest) {
        try {
            User user = userService.getUserById(userId);
            if (user == null) {
                 throw new UserNotFoundException("User not found with ID: " + userId);
            }

            List<Long> skillIds = userSkillsRequest.getSkillIds();

            for (Long skillId : skillIds) {
                userSkillsService.removeSkillFromUser(user, skillId);
            }

            return ResponseEntity.ok("Skills removed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
