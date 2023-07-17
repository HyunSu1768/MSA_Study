package org.fastcampuspay.banking.adapter.out.persistence;

import org.example.common.PersistenceAdapter;
import org.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import org.fastcampuspay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final RegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    ) {
        return bankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid())
                );
    }
}
