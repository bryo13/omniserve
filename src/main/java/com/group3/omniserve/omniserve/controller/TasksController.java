package com.group3.omniserve.omniserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.omniserve.omniserve.models.Tasks;
import com.group3.omniserve.omniserve.services.TasksService;

@RestController
@RequestMapping("/api/v1")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/{user_id}/tasks")
    public ResponseEntity<List<Tasks>> getAllTaskByUserID(@PathVariable(value = "user_id") Long user_id) {
        return tasksService.getAllTaskByUserID(user_id);
    }

    @PostMapping("/users/{user_id}/tasks")
    public Tasks createTasks(@PathVariable(value = "user_id") Long user_id,
            @RequestBody Tasks tasks) {
        return tasksService.createTasks(user_id, tasks);
    }
}
