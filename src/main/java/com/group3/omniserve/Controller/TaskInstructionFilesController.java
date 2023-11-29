package com.group3.omniserve.Controller;
import com.group3.omniserve.Service.TaskInstructionFilesService;
import com.group3.omniserve.model.TaskInstructionFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/task-instruction-files")
public class TaskInstructionFilesController {
   /* private final TaskInstructionFilesService taskInstructionFileService;

    @Autowired
    public TaskInstructionFilesController(TaskInstructionFilesService taskInstructionFileService) {
        this.taskInstructionFileService = taskInstructionFileService;
    }

    // Upload multiple files for a task instruction
    @PostMapping("/upload/{taskInstructionId}")
    public List<TaskInstructionFiles> uploadTaskInstructionFiles(
            @PathVariable Long taskInstructionId,
            @RequestParam("files") List<MultipartFile> files
    ) throws IOException {
        return taskInstructionFileService.uploadTaskInstructionFiles(taskInstructionId, files);
    }

    // Get all files for a specific task instruction
  //  @GetMapping("/{taskInstructionId}")
   // public List<TaskInstructionFiles> getTaskInstructionFiles(@PathVariable Long taskInstructionId) {
     //   return taskInstructionFileService.getTaskInstructionFiles(taskInstructionId);
  //  }

    // Delete a single file by ID
    @DeleteMapping("/delete/{fileId}")
    public void deleteTaskInstructionFile(@PathVariable Long fileId) {
        taskInstructionFileService.deleteTaskInstructionFile(fileId);
    }

    // Delete multiple files by their IDs
    @DeleteMapping("/delete-multiple")
    public void deleteTaskInstructionFiles(@RequestParam("fileIds") List<Long> fileIds) {
        taskInstructionFileService.deleteTaskInstructionFiles(fileIds);
    }
*/
}
