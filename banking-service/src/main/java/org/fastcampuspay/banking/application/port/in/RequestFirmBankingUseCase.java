package org.fastcampuspay.banking.application.port.in;

import org.fastcampuspay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {

    FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command);

}
