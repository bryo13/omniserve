package com.group3.omniserve.Service;
import com.group3.omniserve.Exception.FileSizeExceededException;
import com.group3.omniserve.Exception.InvalidFileTypeException;
import com.group3.omniserve.Exception.TaskInstructionFileNotFoundException;
import com.group3.omniserve.model.TaskInstructionFiles;
import com.group3.omniserve.repository.TaskInstructionFilesRepository;
import com.group3.omniserve.repository.TaskInstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.tika.Tika;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskInstructionFilesService {
  /*  private final TaskInstructionFilesRepository taskInstructionFileRepository;
   

    @Autowired
    public TaskInstructionFilesService(TaskInstructionFilesRepository taskInstructionFileRepository, TaskInstructionRepository taskInstructionRepository) {
        this.taskInstructionFileRepository = taskInstructionFileRepository;
       
    }

    // Upload multiple files for a task instruction
    public List<TaskInstructionFiles> uploadTaskInstructionFiles(Long taskInstructionId, List<MultipartFile> files) throws IOException {
        // Ensure the task instruction exists
        Optional<TaskInstructionFiles> taskInstructionOptional = taskInstructionFileRepository.findById(taskInstructionId);
        if (taskInstructionOptional.isEmpty()) {
            throw new TaskInstructionFileNotFoundException("Task Instruction with ID " + taskInstructionId + " does not exist.");
        }

      
        List<TaskInstructionFiles> uploadedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            // Validate file type and size (implement your own validation logic)
            validateFile(file);

            // Save the file and associate it with the task
         //   TaskInstructionFiles taskInstructionFile = new TaskInstructionFiles();
         //   taskInstructionFile.setTaskInstruction(taskItask_id);
         //   taskInstructionFile.setFileName(file.getOriginalFilename());
         //   taskInstructionFile.setFileSize(file.getSize());
         //   taskInstructionFile.setFileType(file.getContentType());
          //  taskInstructionFile.setFileContent(file.getBytes());
         //   taskInstructionFileRepository.save(taskInstructionFile);
           // uploadedFiles.add(taskInstructionFile);
        }

        return uploadedFiles;
    }

    // Get all files for a specific task instruction
  //  public List<TaskInstructionFiles> getTaskInstructionFiles(Long taskInstructionId) {
   //     return taskInstructionFileRepository.findByTaskInstructionID(taskInstructionId);
   // }

    // Delete a single file by ID
    public void deleteTaskInstructionFile(Long fileId) {
        if (!taskInstructionFileRepository.existsById(fileId)) {
            throw new TaskInstructionFileNotFoundException("Task Instruction File with ID " + fileId + " does not exist.");
        }
        taskInstructionFileRepository.deleteById(fileId);
    }

    // Delete multiple files by their IDs
    public void deleteTaskInstructionFiles(List<Long> fileIds) {
        for (Long fileId : fileIds) {
            if (!taskInstructionFileRepository.existsById(fileId)) {
                throw new TaskInstructionFileNotFoundException("Task Instruction File with ID " + fileId + " does not exist.");
            }
        }
        taskInstructionFileRepository.deleteAllById(fileIds);
    }

    //  file type and size validation logic 
   private void validateFile(MultipartFile file) throws IOException {
        // Validate file type using Apache Tika
        Tika tika = new Tika();
        String detectedType = tika.detect(file.getInputStream());

        // Define allowed file types (add or modify as needed)
        String[] allowedTypes = {"image/jpeg", "image/png", "application/pdf", "application/msword", "application/vnd.ms-excel", "application/msaccess", "audio/*", "video/*"};

        boolean isTypeAllowed = false;
        for (String allowedType : allowedTypes) {
            if (detectedType.startsWith(allowedType) || detectedType.equals(allowedType)) {
                isTypeAllowed = true;
                break;
            }
        }

        if (!isTypeAllowed) {
            throw new InvalidFileTypeException("Invalid file type. Allowed types: image, PDF, Word, Excel, Access, audio, video.");
        }

        // Define the maximum file size in bytes (e.g., 10 MB)
        long maxSizeBytes = 10 * 1024 * 1024; // 10 MB

        if (file.getSize() > maxSizeBytes) {
            throw new FileSizeExceededException("File size exceeds the maximum limit of 10 MB.");
        }
    }
   */
}
