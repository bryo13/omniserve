package com.group3.omniserve.Service;
import com.group3.omniserve.Exception.TaskInstructionNotFoundException;
import com.group3.omniserve.Exception.TaskNotFoundException;
import com.group3.omniserve.model.Task;
import com.group3.omniserve.model.TaskInstruction;
import com.group3.omniserve.repository.TaskInstructionRepository;
import com.group3.omniserve.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskInstructionService {
  /*  private final TaskInstructionRepository taskInstructionRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskInstructionService(TaskInstructionRepository taskInstructionRepository, TaskRepository taskRepository) {
        this.taskInstructionRepository = taskInstructionRepository;
        this.taskRepository = taskRepository;
    }

    // Create a new task instruction
    public TaskInstruction createTaskInstruction(TaskInstruction taskInstruction) {
        // Ensure the TaskID in TaskInstruction relates to an existing task
      //  if (taskInstruction.getTaskID() != null) {
       //     Optional<Task> task = taskRepository.findById(taskInstruction.getTaskID());
     //       if (task.isEmpty()) {
      //          throw new TaskNotFoundException("Task with ID " + taskInstruction.getTaskID() + " does not exist.");
     //       }
     //   }

        // Your business logic for creating a task instruction here
        return taskInstructionRepository.save(taskInstruction);
    }

    // Create multiple task instructions
    public List<TaskInstruction> createTaskInstructions(List<TaskInstruction> taskInstructions) {
        // Your business logic for creating multiple task instructions here
        return taskInstructionRepository.saveAll(taskInstructions);
    }

    // Get all task instructions
    public List<TaskInstruction> getAllTaskInstructions() {
        return taskInstructionRepository.findAll();
    }

    // Get a specific task instruction by ID
    public TaskInstruction getTaskInstructionById(Long id) {
        Optional<TaskInstruction> taskInstruction = taskInstructionRepository.findById(id);
        if (taskInstruction.isPresent()) {
            return taskInstruction.get();
        } else {
            throw new TaskInstructionNotFoundException("Task Instruction not found with ID: " + id);
        }
    }

    // Update a task instruction
    public TaskInstruction updateTaskInstruction(Long id, TaskInstruction updatedTaskInstruction) {
        // Your business logic for updating a task instruction here
        // Ensure the TaskID in TaskInstruction relates to an existing task

     //   if (updatedTaskInstruction.getTaskID() != null) {
     //       Optional<Task> task = taskRepository.findById(updatedTaskInstruction.getTaskID());
      //      if (task.isEmpty()) {
      //          throw new TaskNotFoundException("Task with ID " + updatedTaskInstruction.getTaskID() + " does not exist.");
     //       }
      //  }

        // Update the task instruction with the provided values
     //   updatedTaskInstruction.setID(id);
        return taskInstructionRepository.save(updatedTaskInstruction);
    }

    // Delete a task instruction by ID
    public void deleteTaskInstruction(Long id) {
        if (!taskInstructionRepository.existsById(id)) {
            throw new TaskInstructionNotFoundException("Task Instruction not found with ID: " + id);
        }

        taskInstructionRepository.deleteById(id);
    }

    // Delete multiple task instructions
    public void deleteTaskInstructions(List<Long> taskInstructionIds) {
        // Your business logic for deleting multiple task instructions here
        taskInstructionRepository.deleteAllById(taskInstructionIds);
    }
    */
}
