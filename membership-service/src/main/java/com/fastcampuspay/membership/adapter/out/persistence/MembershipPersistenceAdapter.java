package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final MembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getMembershipName(),
                        membershipAddress.getMembershipAddress(),
                        membershipEmail.getMembershipEmail(),
                        membershipIsCorp.isCorpValue(),
                        membershipIsCorp.isCorpValue()
                )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));

        entity.chagneInfo(
                membershipName.getMembershipName(),
                membershipAddress.getMembershipAddress(),
                membershipEmail.getMembershipEmail(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue());

        return membershipRepository.save(entity);
    }
}
