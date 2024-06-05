package org.formation.repository;

import org.formation.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

	@Query("SELECT ca FROM CurrentAccount ca WHERE ca.client.id = :clientId")
	CurrentAccount findByClientId(@Param("clientId") Long clientId);
}
