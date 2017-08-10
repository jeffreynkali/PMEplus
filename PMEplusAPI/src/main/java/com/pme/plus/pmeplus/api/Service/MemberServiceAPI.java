package com.pme.plus.pmeplus.api.Service;


import com.pme.plus.pmeplus.Entity.Member;

/**
 * Created by gnkali on 7/29/17.
 */
public interface MemberServiceAPI {

    Iterable<Member> listAllMembers();

    Member getMemberById(Integer id);

    Member saveMember(Member member);

    void deleteMember(Integer id);
}
