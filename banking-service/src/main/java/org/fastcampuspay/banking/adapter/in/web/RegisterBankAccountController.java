package org.fastcampuspay.banking.adapter.in.web;

import org.example.common.WebAdapter;
import org.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import org.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import org.fastcampuspay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request){

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .bankAccountNumber(request.getBankAccountNumber())
                .bankName(request.getBankName())
                .membershpId(request.getMembershipId())
                .isValid(request.isValid())
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerMembership(command);

        if(registeredBankAccount == null){
            return null;
        }

        return registerBankAccountUseCase.registerMembership(command);

    }

}
