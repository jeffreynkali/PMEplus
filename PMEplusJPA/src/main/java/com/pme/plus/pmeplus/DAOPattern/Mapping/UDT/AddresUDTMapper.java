package com.pme.plus.pmeplus.DAOPattern.Mapping.UDT;

import com.pme.plus.pmeplus.Entity.UDT.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/20/17.
 */
public class AddresUDTMapper implements RowMapper<Address> {

    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        address.setProvince(rs.getString("province"));
        address.setPostalCode(rs.getString("postalCode"));

        return address;
    }


}
