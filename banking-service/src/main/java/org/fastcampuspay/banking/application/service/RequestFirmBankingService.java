package org.fastcampuspay.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.example.common.UseCase;
import org.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.fastcampuspay.banking.adapter.out.external.bank.FirmBankingResult;
import org.fastcampuspay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import org.fastcampuspay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import org.fastcampuspay.banking.application.port.in.RequestFirmBankingCommand;
import org.fastcampuspay.banking.application.port.in.RequestFirmBankingUseCase;
import org.fastcampuspay.banking.application.port.out.RequestExternalFirmbankingPort;
import org.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import org.fastcampuspay.banking.domain.FirmBankingRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@RequiredArgsConstructor
@Transactional
@UseCase
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmbankingPort requestFirmbankingPort;

    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    private final FirmbankingRequestMapper mapper;

    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {

        FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankingRequest.FirmbankingStatus(0)
        );

        FirmBankingResult firmBankingResult = requestExternalFirmbankingPort.requestExternalFirmBanking((
                new ExternalFirmbankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                )
        ));

        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID.toString());

        if(firmBankingResult.getResultCode()==0){
            requestedEntity.setFirmBankingStatus(1);
        }
        else{
            requestedEntity.setFirmBankingStatus(2);
        }

        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
    }
}
