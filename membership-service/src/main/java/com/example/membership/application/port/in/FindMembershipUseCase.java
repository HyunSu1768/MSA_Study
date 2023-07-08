package org.example.membership.application.port.in;

import org.example.membership.adapter.out.persistence.MembershipJpaEntity;
import org.example.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
