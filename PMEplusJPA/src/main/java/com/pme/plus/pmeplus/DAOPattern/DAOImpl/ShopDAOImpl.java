package com.pme.plus.pmeplus.DAOPattern.DAOImpl;

import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.ShopDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.ShopMapper;
import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.Entity.UDT.Address;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnkali on 6/20/17.
 */
public class ShopDAOImpl implements ShopDAO, DatasourceDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Connection connection;
    private ShopMapper mapper;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.mapper = new ShopMapper();
    }

    public void createShop(Address address, String phone, String email) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createShop( ?, ?, ? ) } ");
            statement.setObject(1, address);
            statement.setString(2, phone);
            statement.setString(3, email);
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

    public Shop getShopByID(int idShop) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<Shop> shops = new ArrayList<Shop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getShopByID(?)");
            statement.setInt(1,idShop);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                shops.add(mapper.mapRow(rs, 0));
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
        return shops.get(0);
    }

    public List<Shop> listShops() {
        List<Shop> shops = new ArrayList<Shop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllShops() ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                shops.add(mapper.mapRow(rs, 0));
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
        return shops;
    }

    public void deleteShopByID(int idShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteShopByID( ? ) } ");
            statement.setInt(1, idShop);
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

    public void updateShopEmail(int idShop, String email) {
        List<Shop> shops = new ArrayList<Shop>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateShopEmail( ?, ? ) } ");
            statement.setInt(1, idShop);
            statement.setString(2, email);
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
