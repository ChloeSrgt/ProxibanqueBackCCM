package org.formation.repository;

import org.formation.model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {

    @Query("SELECT sa FROM SavingAccount sa WHERE sa.client.id = :clientId")
    SavingAccount findByClientId(@Param("clientId") Long clientId);
}
