package org.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {

    @Getter private final Long firmbankingRequestId;

    @Getter private final String fromBankName;

    @Getter private final String fromBankAccountNumber;

    @Getter private final String toBankName;

    @Getter private final String toBankAccountNumber;

    @Getter private final int moneyAmount;

    @Getter private final int firmbankingStatus;

    @Getter private final UUID uuid;

    public static FirmBankingRequest generateFirmbankingRequest(
            FirmbankingRequestId firmbankingRequestId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            MoneyAmount moneyAmount,
            FirmbankingStatus firmbankingStatus,
            UUID uuid
    ){
        return new FirmBankingRequest(
                firmbankingRequestId.firmbankingRequestId,
                fromBankName.fromBankName,
                fromBankAccountNumber.fromBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.amount,
                firmbankingStatus.firmbankingStatus,
                uuid
        );
    }

    @Value
    public static class FirmbankingRequestId {

        public FirmbankingRequestId(Long value) {
            this.firmbankingRequestId = value;
        }

        Long firmbankingRequestId;

    }

    @Value
    public static class FromBankName{

        public FromBankName(String value) {
            this.fromBankName = value;
        }

        String fromBankName;

    }

    @Value
    public static class FromBankAccountNumber{

        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }

        String fromBankAccountNumber;

    }

    @Value
    public static class ToBankName{

        public ToBankName(String value) {
            this.toBankName = value;
        }

        String toBankName;

    }

    @Value
    public static class ToBankAccountNumber{

        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber = value;
        }

        String toBankAccountNumber;

    }
    
    @Value
    public static class MoneyAmount{

        public MoneyAmount(int value){
            this.amount = value;
        }

        int amount;

    }

    @Value
    public static class FirmbankingStatus{

        public FirmbankingStatus(int value){
            this.firmbankingStatus = value;
        }

        int firmbankingStatus;

    }


}
