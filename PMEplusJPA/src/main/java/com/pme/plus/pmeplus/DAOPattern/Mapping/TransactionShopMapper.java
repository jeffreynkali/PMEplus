package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.TransactionShop;
import com.pme.plus.pmeplus.Entity.UDT.TransactionShopId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/21/17.
 */
public class TransactionShopMapper implements RowMapper<TransactionShop> {

    public TransactionShop mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionShop transactionShop = new TransactionShop();
        transactionShop.setId(new TransactionShopId(rs.getInt("idProduct"), rs.getInt("idShop"), rs.getInt("idMember")));
        transactionShop.setTransactionTimestamp(rs.getDate("transactionTimestamp"));
        transactionShop.setQuantity(rs.getInt("quantity"));

        return transactionShop;
    }
}
