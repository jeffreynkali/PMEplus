package com.pme.plus.pmeplus.api.Controller;


import com.pme.plus.pmeplus.Entity.Member;

import java.util.List;

/**
 * Created by gnkali on 6/27/17.
 */

public interface MemberControllerAPI {

    /**
     * Returns the list of all members currently existing in the system
     *
     * @return a list of all Members
     */
    List<Member> getAllMembers() ;

    /**
     * Returns a specific member based on its idMember
     *
     * @param idMember the idMember of the member we are looking for
     * @return a specific member based on his idMember
     */
    Member getMemberByID(int idMember);

    /**
     * Create a new member
     *
     * @param member the new member to be created
     */
    void createMember(Member member);

    /**
     * Update an existing member.
     *
     * @param member the new value to update the member with
     */
    void updateMember(Member member);

    /**
     * delete an existing member based on its idMember
     *
     * @param idMember
     */
    void deleteMemberById(int idMember);

    /**
     * Verifies if a specific member entity already exist in the system
     *
     * @param member the member to check for his existence
     * @return a boolean indicating whether or not the member already exists
     */
    boolean isMemberExist(Member member);

}
