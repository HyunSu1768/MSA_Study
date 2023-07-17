package org.fastcampuspay.banking.application.port.out;

import org.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.fastcampuspay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );

}
