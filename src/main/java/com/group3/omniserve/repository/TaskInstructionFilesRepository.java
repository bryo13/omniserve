package com.group3.omniserve.repository;
import com.group3.omniserve.model.TaskInstructionFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskInstructionFilesRepository extends JpaRepository<TaskInstructionFiles, Long> {
 
    
}
