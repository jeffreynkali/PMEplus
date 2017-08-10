package com.pme.plus.pmeplus.DAOPattern.Mapping;

import com.pme.plus.pmeplus.Entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gnkali on 6/20/17.
 */
public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setIdProduct(rs.getInt("idProduct"));
        product.setName(rs.getString("name"));
        product.setCategory(rs.getString("category"));

        return product;
    }
}
