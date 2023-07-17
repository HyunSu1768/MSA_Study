package org.fastcampuspay.banking.application.port.out;

import org.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import org.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);

}
