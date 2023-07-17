package org.example.membership.application.service;

import org.example.membership.application.port.in.RegisterMembershipCommand;
import org.example.membership.application.port.in.RegisterMembershipUseCase;
import org.example.membership.application.port.out.RegisterMembershipPort;
import org.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.example.common.UseCase;
import org.example.membership.adapter.out.persistence.MembershipJpaEntity;
import org.example.membership.adapter.out.persistence.MembershipMapper;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity membership = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(membership);

    }

}