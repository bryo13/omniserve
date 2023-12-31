package com.group3.omniserve.omniserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group3.omniserve.omniserve.models.User;

// methods from the interface are automatically plugged in by the 
// Spring Data JPA 
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
