package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.Member;

/**
 * Created by gnkali on 6/15/17.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {

    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setIdMember(rs.getInt("idMember"));
        member.setFirstname(rs.getString("firstname"));
        member.setLastname(rs.getString("lastname"));
        member.setEmail(rs.getString("email"));

        return member;
    }
}
