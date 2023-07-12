package com.fastcampuspay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private String membershipId;

    private String registeredBankAccountId;

    private String bankName;

    private String bankAccountNumber;

    private boolean linkedStatusIsValid;

    public RegisteredBankAccountJpaEntity(String registeredBankAccountId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.registeredBankAccountId = registeredBankAccountId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
