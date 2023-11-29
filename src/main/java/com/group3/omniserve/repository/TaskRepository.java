
package com.group3.omniserve.repository;

import com.group3.omniserve.model.Task;
import com.group3.omniserve.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByClient(User client);
    
    List<Task> findByProvider(User provider);
}
