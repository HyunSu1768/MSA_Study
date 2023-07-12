package com.fastcampuspay.banking.application.service;

import com.example.common.UseCase;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisteredBankAccount registerMembership(RegisterBankAccountCommand command) {
        RegisteredBankAccountJpaEntity registeredBankAccount = registerBankAccountPort.createRegisteredBankAccount(
                new RegisteredBankAccount.MembershipId(command.getMembershpId()),
                new RegisteredBankAccount.BankName(command.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
        );
        return registeredBankAccountMapper.mapToDomainEntity(registeredBankAccount);
    }
}