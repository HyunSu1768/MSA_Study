package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.fastcampuspay.banking.domain.FirmBankingRequest;

public interface RequestFirmbankingPort {

    FirmbankingRequestJpaEntity createFirmbankingRequest(
        FirmBankingRequest.FromBankName fromBankName,
        FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
        FirmBankingRequest.ToBankName toBankName,
        FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
        FirmBankingRequest.MoneyAmount moneyAmount,
        FirmBankingRequest.FirmbankingStatus firmbankingStatus
    );

    FirmbankingRequestJpaEntity modifyFirmbankingRequest(
            FirmbankingRequestJpaEntity entity
    );
}
