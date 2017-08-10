package com.pme.plus.pmeplus.Impl.Service;

import com.pme.plus.pmeplus.Entity.Member;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.MemberRepository;
import com.pme.plus.pmeplus.api.Service.MemberServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gnkali on 7/29/17.
 */
@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberServiceAPI {

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Iterable<Member> listAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Integer id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.delete(id);
    }
}
