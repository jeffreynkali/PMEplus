package com.pme.plus.pmeplus.DAOPattern.DAOImpl;

import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.ProductShopDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.ProductShopMapper;
import com.pme.plus.pmeplus.Entity.ProductShop;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public class ProductShopDAOImpl implements ProductShopDAO, DatasourceDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Connection connection;
    private ProductShopMapper mapper;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.mapper = new ProductShopMapper();
    }

    public void createProductShop(ProductShop productShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createProductShop( ?, ?, ?, ?, ?, ? ) } ");
            statement.setInt(1, productShop.getId().getIdProduct());
            statement.setInt(2, productShop.getId().getIdShop());
            statement.setString(3, productShop.getName());
            statement.setDate(4, productShop.getPromotionStartTimestamp());
            statement.setDate(5, productShop.getPromotionEndTimestamp());
            statement.setInt(6, productShop.getPointsPerItem());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }

    }

    public ProductShop getProductShopByIDs(int idProduct, int idShop) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<ProductShop> productShops = new ArrayList<ProductShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getProductShopByIDs(?, ?)");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                productShops.add(mapper.mapRow(rs, 0));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return productShops.get(0);
    }

    public List<ProductShop> listProductShops() {
        List<ProductShop> productShops = new ArrayList<ProductShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllProductShops() ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                productShops.add(mapper.mapRow(rs, 0));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return productShops;
    }

    public void deleteProductShopByIDs(int idProduct, int idShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteProductShopByIDs( ?, ?) } ");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateProductShopName(int idProduct, int idShop, String name) {
        List<ProductShop> productShops = new ArrayList<ProductShop>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateProductShopName( ?, ?, ? ) } ");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.setString(3, name);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateProductShopPointsPerItem(int idProduct, int idShop, int pointsPerItem) {
        List<ProductShop> productShops = new ArrayList<ProductShop>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateProductShopPointsPerItem( ?, ?, ? ) } ");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.setInt(3, pointsPerItem);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }
}
