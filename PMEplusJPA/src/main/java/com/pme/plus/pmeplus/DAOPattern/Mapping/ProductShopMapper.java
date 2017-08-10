package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.ProductShop;
import com.pme.plus.pmeplus.Entity.UDT.ProductShopId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/21/17.
 */
public class ProductShopMapper implements RowMapper<ProductShop> {

    public ProductShop mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductShop productShop = new ProductShop();
        productShop.setId(new ProductShopId(rs.getInt("idProduct"), rs.getInt("idShop")));
        productShop.setName(rs.getString("name"));
        productShop.setPromotionStartTimestamp(rs.getDate("promotionStartTimestamp"));
        productShop.setPromotionEndTimestamp(rs.getDate("promotionEndTimestamp"));
        productShop.setPointsPerItem(rs.getInt("pointsPerItem"));

        return productShop;
    }
}
