package org.example.membership.application.service;

import org.example.membership.application.port.in.FindMembershipUseCase;
import org.example.membership.application.port.out.FindMembershipPort;
import org.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.example.common.UseCase;
import org.example.membership.adapter.out.persistence.MembershipJpaEntity;
import org.example.membership.adapter.out.persistence.MembershipMapper;
import org.example.membership.application.port.in.FindMembershipCommand;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMEmbershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMEmbershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity);

    }

}
