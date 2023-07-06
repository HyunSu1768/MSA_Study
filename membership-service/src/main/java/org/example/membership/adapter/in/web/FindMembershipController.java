package org.example.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.common.WebAdapter;
import org.example.membership.adapter.out.persistence.MembershipJpaEntity;
import org.example.membership.adapter.out.persistence.MembershipPersistenceAdapter;
import org.example.membership.application.port.in.FindMembershipCommand;
import org.example.membership.application.port.in.FindMembershipUseCase;
import org.example.membership.application.port.in.RegisterMembershipCommand;
import org.example.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
