package com.group3.omniserve.omniserve.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group3.omniserve.omniserve.models.Tasks;

// methods from the interface are automatically plugged in by the 
// Spring Data JPA 
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{
    @Query(value = "SELECT * FROM tasks WHERE user_id=?1",nativeQuery = true)
    List<Tasks> findAllTasksByUser(long user_id);
}
