package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );

}
