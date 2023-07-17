package org.fastcampuspay.banking.application.port.in;

import org.fastcampuspay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerMembership(RegisterBankAccountCommand command);

}
