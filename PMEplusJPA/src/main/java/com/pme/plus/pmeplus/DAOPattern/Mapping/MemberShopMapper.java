package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.MemberShop;
import com.pme.plus.pmeplus.Entity.UDT.MemberShopId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/21/17.
 */
public class MemberShopMapper implements RowMapper<MemberShop> {

    public MemberShop mapRow(ResultSet rs, int rowNum) throws SQLException {
        MemberShop memberShop = new MemberShop();
        memberShop.setId(new MemberShopId(rs.getInt("idMember"), rs.getInt("idShop")));
        memberShop.setCardNumber(rs.getString("cardNumber"));
        memberShop.setPoints(rs.getLong("points"));
        memberShop.setRegistrationDate(rs.getDate("registrationDate"));

        return memberShop;
    }
}
