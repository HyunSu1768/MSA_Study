package org.fastcampuspay.banking.adapter.out.persistence;

import org.fastcampuspay.banking.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmbankingRequestMapper {

    public FirmBankingRequest mapToDomainEntity(FirmbankingRequestJpaEntity firmbankingRequestJpaEntity, UUID uuid){
        return FirmBankingRequest.generateFirmbankingRequest(
                new FirmBankingRequest.FirmbankingRequestId(firmbankingRequestJpaEntity.getRequestFirmBankingId()),
                new FirmBankingRequest.FromBankName(firmbankingRequestJpaEntity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(firmbankingRequestJpaEntity.getFromBankName()),
                new FirmBankingRequest.ToBankName(firmbankingRequestJpaEntity.getFromBankName()),
                new FirmBankingRequest.ToBankAccountNumber(firmbankingRequestJpaEntity.getFormBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(firmbankingRequestJpaEntity.getFirmBankingStatus()),
                new FirmBankingRequest.FirmbankingStatus(firmbankingRequestJpaEntity.getFirmBankingStatus()),
                uuid
        );
    }

}
