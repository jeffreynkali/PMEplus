package com.pme.plus.pmeplus.Impl.Controller;

import com.pme.plus.pmeplus.DAOPattern.DAO.MemberDAO;
import com.pme.plus.pmeplus.DAOPattern.DAOImpl.MemberDAOImpl;
import com.pme.plus.pmeplus.api.Controller.MemberControllerAPI;
import com.pme.plus.pmeplus.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by gnkali on 6/27/17.
 */

@Controller("memberControllerImpl")
public class MemberControllerImpl implements MemberControllerAPI {

    @Autowired
    private MemberDAO memberDAO;

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<Member> getAllMembers() {
        return memberDAO.getMembers();
    }

    public Member getMemberByID(int idMember) {
        return memberDAO.getMemberByID(idMember);
    }

    public void createMember(Member member) {
        memberDAO.createMember(member.getFirstname(), member.getLastname(), member.getEmail());
    }

    public void updateMember(Member member) {
        memberDAO.updateMemberEmail(member.getIdMember(), member.getEmail());
    }

    public void deleteMemberById(int idMember) {
        memberDAO.deleteMemberByID(idMember);
    }

    public boolean isMemberExist(Member member) {
        Member existingMember = memberDAO.getMemberByID(member.getIdMember());
        if (existingMember == null) {
            return false;
        }
        return true;
    }
}
