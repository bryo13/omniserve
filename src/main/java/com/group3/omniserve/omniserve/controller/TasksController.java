package com.group3.omniserve.omniserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.omniserve.omniserve.models.Tasks;

@RestController
@RequestMapping("/api/v1")
public class TasksController {
 
    @Autowired
    private TasksService tasksService;

    @GetMapping("/users/{userID}/tasks")
    public ResponseEntity<List<Tasks>> getAllTaskByUserID(@PathVariable(value = "UserID") Long userID) {
        return tasksService.getAllTaskByUserID(userID);
    }
}
