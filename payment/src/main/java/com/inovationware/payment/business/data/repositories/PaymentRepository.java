package com.inovationware.payment.business.data.repositories;

import com.inovationware.payment.business.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p where p.clientEmail = :email")
    List<Payment> findByClientEmail(@Param("email") String email);

}
