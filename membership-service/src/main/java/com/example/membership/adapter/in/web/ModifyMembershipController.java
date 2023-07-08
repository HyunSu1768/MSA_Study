package com.example.membership.adapter.in.web;

import com.example.membership.application.port.in.ModifyMembershipCommand;
import com.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import com.example.common.WebAdapter;
import com.example.membership.application.port.in.ModifyMembershipUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@WebAdapter
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping(path = "/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembershipById(@RequestBody ModifyMembershipRequest request){

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .address(request.getAddress())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));

    }

}
