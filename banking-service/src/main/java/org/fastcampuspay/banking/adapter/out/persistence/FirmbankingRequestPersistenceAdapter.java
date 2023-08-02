package org.fastcampuspay.banking.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.common.PersistenceAdapter;
import org.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import org.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import org.fastcampuspay.banking.domain.FirmBankingRequest;
import org.fastcampuspay.banking.domain.RegisteredBankAccount;

import java.util.UUID;

@RequiredArgsConstructor
@PersistenceAdapter
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;

    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(
            FirmBankingRequest.FromBankName fromBankName,
            FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmBankingRequest.ToBankName toBankName,
            FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankingRequest.MoneyAmount moneyAmount,
            FirmBankingRequest.FirmbankingStatus firmbankingStatus
    ) {

        FirmbankingRequestJpaEntity firmbankingRequestJpaEntity = new FirmbankingRequestJpaEntity(
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getAmount(),
                firmbankingStatus.getFirmbankingStatus(),
                UUID.randomUUID()
        );

        return firmbankingRequestRepository.save(firmbankingRequestJpaEntity);

    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }

}


