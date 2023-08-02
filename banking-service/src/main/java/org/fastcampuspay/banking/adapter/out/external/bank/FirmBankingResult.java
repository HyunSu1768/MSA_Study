package org.fastcampuspay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmBankingResult {

    private int resultCode;

    public FirmBankingResult(int resultCode) {
        this.resultCode = resultCode;
    }

}
