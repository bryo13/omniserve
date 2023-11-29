package com.group3.omniserve.repository;

import com.group3.omniserve.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    
}
