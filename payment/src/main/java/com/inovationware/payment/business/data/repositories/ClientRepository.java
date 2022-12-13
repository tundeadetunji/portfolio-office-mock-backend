package com.inovationware.payment.business.data.repositories;

import com.inovationware.payment.business.data.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c where c.email = :email")
    Client findByEmail(@Param("email") String email);

}
