package org.emsi.ebankingbackend.repositories;

import org.emsi.ebankingbackend.entities.AccountOperation;
import org.emsi.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
}
