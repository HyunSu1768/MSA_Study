package org.fastcampuspay.banking.application.port.out;

import org.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.fastcampuspay.banking.adapter.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmbankingPort {
    FirmBankingResult requestExternalFirmBanking(ExternalFirmbankingRequest request);
}
