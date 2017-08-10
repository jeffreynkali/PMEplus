package com.pme.plus.pmeplus.DAOPattern.DAO;

/**
 * Created by gnkali on 6/15/17.
 */

import com.pme.plus.pmeplus.Entity.Member;

import java.util.List;

public interface MemberDAO {

    /**
     * This is the method to be used to create
     * a record in the Member table.
     */
    public void createMember(String firstname, String lastname, String email);

    /**
     * This is the method to be used to list down
     * a record from the Member table corresponding
     * to a passed Member idMember.
     */
    public Member getMemberByID(int idMember);

    /**
     * This is the method to be used to list down
     * all the records from the Member table.
     */
    public List<Member> getMembers();

    /**
     * This is the method to be used to delete
     * a record from the Member table corresponding
     * to a passed Member idMember.
     */
    public void deleteMemberByID(int idMember);

    /**
     * This is the method to be used to update
     * a record's Email into the Member table.
     */
    public void updateMemberEmail(int idMember, String email);

    /**
     * This is the method to be used to update
     * a record's firstname into the Member table.
     */
    public void updateMemberFirstname(int idMember, String firstname);

    /**
     * This is the method to be used to update
     * a record's lastname into the Member table.
     */
    public void updateMemberLastname(int idMember, String lastname);

    /**
     * This is the method to be used to update
     * a record into the Member table.
     */
    public void updateMemberByID(int idMember, String firstname, String lastname, String email);
}

