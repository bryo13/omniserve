
package com.group3.omniserve.repository;

import com.group3.omniserve.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Long> {
    
}
