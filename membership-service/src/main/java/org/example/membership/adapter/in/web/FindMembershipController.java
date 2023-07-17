package org.example.membership.adapter.in.web;

import org.example.membership.application.port.in.FindMembershipUseCase;
import org.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.example.common.WebAdapter;
import org.example.membership.application.port.in.FindMembershipCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping(path = "/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId){

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));

    }

}