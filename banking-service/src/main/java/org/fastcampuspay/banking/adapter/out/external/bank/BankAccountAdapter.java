package org.fastcampuspay.banking.adapter.out.external.bank;

import org.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
