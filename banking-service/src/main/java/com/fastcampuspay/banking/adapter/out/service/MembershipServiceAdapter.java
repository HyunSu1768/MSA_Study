package com.fastcampuspay.banking.adapter.out.service;

import com.fastcampuspay.banking.application.port.out.GetMembershipPort;
import com.fastcampuspay.banking.application.port.out.MembershipStatus;
import com.fastcampuspay.common.CommonHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter implements GetMembershipPort {

    private final CommonHttpClient commonHttpClient;

    private final String membershipServiceUrl;

    public MembershipServiceAdapter(
            CommonHttpClient commonHttpClient,
            @Value("${service.membership.url}") String membershipServiceUrl) {
        this.commonHttpClient = commonHttpClient;
        this.membershipServiceUrl = membershipServiceUrl;
    }


    @Override
    public MembershipStatus getMembership(String membershipId) {

        String url = String.join("/", membershipServiceUrl, "membership", membershipId);

        System.out.println(url);

        try{
            String json = commonHttpClient.sendGetRequest(url).body();
            ObjectMapper mapper = new ObjectMapper();
            Membership membership = mapper.readValue(json, Membership.class);

            if (membership.isValid()){
                return new MembershipStatus(membershipId, true);
            } else {
                return new MembershipStatus(membershipId, false);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
