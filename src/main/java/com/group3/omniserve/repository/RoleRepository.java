
package com.group3.omniserve.repository;

/**
 *
 * @author stephen masaku
 */

import com.group3.omniserve.model.Role;
import com.group3.omniserve.model.RoleName;
import com.group3.omniserve.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
  
    


}