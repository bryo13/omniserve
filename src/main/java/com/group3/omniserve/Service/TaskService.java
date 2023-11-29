package com.group3.omniserve.Service;
import com.group3.omniserve.Exception.UserNotFoundException;
import com.group3.omniserve.Exception.TaskNotFoundException;
import com.group3.omniserve.model.Task;
import com.group3.omniserve.model.User;
import com.group3.omniserve.model.TaskInstruction;
import com.group3.omniserve.model.TaskInstructionFiles;
import com.group3.omniserve.dto.TaskPostRequest;
import com.group3.omniserve.dto.TaskInstructionRequest;
import com.group3.omniserve.dto.TaskInstructionFilesRequest;
import com.group3.omniserve.repository.TaskRepository;
import com.group3.omniserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Task createTask(TaskPostRequest taskRequest) {
        Task task = new Task();
        task.setTaskTitle(taskRequest.getTaskTitle());
        task.setTaskDescription(taskRequest.getTaskDescription());
        task.setBudget(taskRequest.getBudget());
        task.setDeadline(taskRequest.getDeadline());

        // Load the client user entity
        User client = userRepository.findById(taskRequest.getClientId())
                .orElseThrow(() -> new UserNotFoundException("Client user not found with ID: " + taskRequest.getClientId()));
        task.setClient(client);

       


        Task createdTask = taskRepository.save(task);
        return createdTask;
    }

    public Task updateTask(Long taskId, TaskPostRequest taskRequest) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task not found with ID: " + taskId);
        }

        Task task = optionalTask.get();
        // Update task properties based on taskRequest

        // Load the client user entity
        User client = userRepository.findById(taskRequest.getClientId())
                .orElseThrow(() -> new UserNotFoundException("Client user not found with ID: " + taskRequest.getClientId()));
        task.setClient(client);

        // You may need to add additional update logic here

        Task updatedTask = taskRepository.save(task);
        return updatedTask;
    }

    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException("Task not found with ID: " + taskId);
        }

        taskRepository.deleteById(taskId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + taskId));
    }
    
     public List<Task> getTasksByClient(User client) {
        return taskRepository.findByClient(client);
    }
     
      public List<Task> getTasksByProvider(User provider) {
        return taskRepository.findByProvider(provider);
    }
}
