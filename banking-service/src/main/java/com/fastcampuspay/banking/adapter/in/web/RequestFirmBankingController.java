package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingUseCase;
import com.fastcampuspay.banking.domain.FirmBankingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firmbanking/request")
    FirmBankingRequest registerMembership(@RequestBody RequestFirmBankingCommand request){

        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmBankingUseCase.requestFirmBanking(command);

    }

}
