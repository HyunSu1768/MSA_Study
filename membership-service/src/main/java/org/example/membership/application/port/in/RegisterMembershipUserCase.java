package org.example.membership.application.port.in;

import org.example.common.UserCase;
import org.example.membership.domain.Membership;

public interface RegisterMembershipUserCase {

    Membership registerMembership(RegisterMembershipCommand command);

}
