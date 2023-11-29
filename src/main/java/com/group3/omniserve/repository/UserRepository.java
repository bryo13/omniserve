package com.group3.omniserve.repository;

/**
 *
 * @author stephen masaku
 */

import com.group3.omniserve.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
  Optional<User> findById(Long userId);
  
List<User> findByRolesContaining(String roleName);

    Optional<User> findByIdAndRolesContaining(Long id, String roleName);
}