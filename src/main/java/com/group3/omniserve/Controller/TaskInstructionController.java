package com.group3.omniserve.Controller;
import com.group3.omniserve.Service.TaskInstructionService;
import com.group3.omniserve.model.TaskInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-instructions")
public class TaskInstructionController {
  /*  private final TaskInstructionService taskInstructionService;

    @Autowired
    public TaskInstructionController(TaskInstructionService taskInstructionService) {
        this.taskInstructionService = taskInstructionService;
    }

    // Create a new task instruction
    @PostMapping
    public TaskInstruction createTaskInstruction(@RequestBody TaskInstruction taskInstruction) {
        return taskInstructionService.createTaskInstruction(taskInstruction);
    }

    // Create multiple task instructions in a single request
    @PostMapping("/create-multiple")
    public List<TaskInstruction> createTaskInstructions(@RequestBody List<TaskInstruction> taskInstructions) {
        return taskInstructionService.createTaskInstructions(taskInstructions);
    }

    // Get all task instructions
    @GetMapping
    public List<TaskInstruction> getAllTaskInstructions() {
        return taskInstructionService.getAllTaskInstructions();
    }

    // Get a specific task instruction by ID
    @GetMapping("/{id}")
    public TaskInstruction getTaskInstructionById(@PathVariable Long id) {
        return taskInstructionService.getTaskInstructionById(id);
    }

    // Update a task instruction
    @PutMapping("/{id}")
    public TaskInstruction updateTaskInstruction(@PathVariable Long id, @RequestBody TaskInstruction taskInstruction) {
        return taskInstructionService.updateTaskInstruction(id, taskInstruction);
    }

    // Delete a task instruction by ID
    @DeleteMapping("/{id}")
    public void deleteTaskInstruction(@PathVariable Long id) {
        taskInstructionService.deleteTaskInstruction(id);
    }

    // Delete multiple task instructions in a single request
    @DeleteMapping("/delete-multiple")
    public void deleteTaskInstructions(@RequestBody List<Long> taskInstructionIds) {
        taskInstructionService.deleteTaskInstructions(taskInstructionIds);
    }
*/
}
