package com.group3.omniserve.Controller;
import com.group3.omniserve.Service.TaskService;
import com.group3.omniserve.model.Task;
import com.group3.omniserve.model.User;
import com.group3.omniserve.dto.TaskPostRequest;
import com.group3.omniserve.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserRepository userRepository;
 
  @Autowired
    public TaskController(TaskService taskService, UserRepository userRepository) {
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    // Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskPostRequest taskRequest) {
        Task createdTask = taskService.createTask(taskRequest);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Get a specific task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // Update a task by ID
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody TaskPostRequest taskRequest) {
        Task updatedTask = taskService.updateTask(id, taskRequest);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
     @GetMapping("/byClient/{clientId}")
    public ResponseEntity<List<Task>> getTasksByClient(@PathVariable Long clientId) {
        Optional<User> userOptional = userRepository.findById(clientId);

        if (userOptional.isEmpty()) {
            // Handle the case where the user with the given ID doesn't exist.
            return ResponseEntity.notFound().build();
        }

        User client = userOptional.get();
        List<Task> tasks = taskService.getTasksByClient(client);
        return ResponseEntity.ok(tasks);
    }
    
     @GetMapping("/byProvider/{providerId}")
    public ResponseEntity<List<Task>> getTasksByProvider(@PathVariable Long providerId) {
        Optional<User> providerOptional = userRepository.findById(providerId);

        if (providerOptional.isEmpty()) {
            // Handle the case where the provider with the given ID doesn't exist.
            return ResponseEntity.notFound().build();
        }

        User provider = providerOptional.get();
        List<Task> tasks = taskService.getTasksByProvider(provider);

        // You might want to add additional logic here for error handling or other requirements.

        return ResponseEntity.ok(tasks);
    }
}
