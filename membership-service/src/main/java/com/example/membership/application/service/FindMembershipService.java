package com.example.membership.application.service;

import com.example.membership.application.port.in.FindMembershipUseCase;
import com.example.membership.application.port.out.FindMembershipPort;
import com.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import com.example.common.UseCase;
import com.example.membership.adapter.out.persistence.MembershipJpaEntity;
import com.example.membership.adapter.out.persistence.MembershipMapper;
import com.example.membership.application.port.in.FindMembershipCommand;
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
