
package com.group3.omniserve.repository;

import com.group3.omniserve.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}