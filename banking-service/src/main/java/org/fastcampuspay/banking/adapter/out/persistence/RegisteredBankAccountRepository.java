package org.fastcampuspay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredBankAccountRepository extends JpaRepository<RegisteredBankAccountJpaEntity, Long> {

}