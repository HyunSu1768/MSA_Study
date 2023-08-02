package org.fastcampuspay.banking.adapter.out.external.bank;

import org.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import lombok.RequiredArgsConstructor;
import org.fastcampuspay.banking.application.port.out.RequestExternalFirmbankingPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBanking(ExternalFirmbankingRequest request) {
        // 실제로 외부 은행에 Http 통신을 통해서
        // 펌뱅킹 요청을 보낸다.
        return new FirmBankingResult(0);
    }
}
