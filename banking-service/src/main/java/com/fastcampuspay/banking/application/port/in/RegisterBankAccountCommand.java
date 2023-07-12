package com.fastcampuspay.banking.application.port.in;

import com.example.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    private final String membershpId;

    @NotNull
    private final String bankName;

    @NotNull
    private final String bankAccountNumber;

    @NotNull
    private final boolean isValid;

    public RegisterBankAccountCommand(String membershpId, String bankName, String bankAccountNumber, boolean isValid) {
        this.membershpId = membershpId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;

        validateSelf();
    }
}
