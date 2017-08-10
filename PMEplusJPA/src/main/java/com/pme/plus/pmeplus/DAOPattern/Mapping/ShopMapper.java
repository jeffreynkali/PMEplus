package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.Entity.UDT.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/20/17.
 */
public class ShopMapper implements RowMapper<Shop> {

    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shop shop = new Shop();
        shop.setIdShop(rs.getInt("idShop"));
        shop.setAddress((Address)rs.getObject("address"));
        shop.setPhone(rs.getString("phone"));
        shop.setEmail(rs.getString("email"));
        shop.setRegistrationDate(rs.getDate("registrationDate"));

        return shop;
    }
}
