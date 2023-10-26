package com.group3.omniserve.omniserve.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.group3.omniserve.omniserve.models.Tasks;
import com.group3.omniserve.omniserve.repositories.TasksRepository;
import com.group3.omniserve.omniserve.repositories.UserRepository;

@Service
public class TasksService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TasksRepository tasksRepository;

    public ResponseEntity<List<Tasks>> getAllTaskByUserID(@PathVariable(value = "UserID") Long userID) {
        if (!userRepository.existsById(userID)) {
            return new ResponseEntity<List<Tasks>>(null, null, HttpStatus.NOT_FOUND);
        }
      
          List<Tasks> tasks = new ArrayList<>();
          tasksRepository.findAll().forEach(tasks::add);
          
          return new ResponseEntity<>(tasks, HttpStatus.OK);
        
    }

}