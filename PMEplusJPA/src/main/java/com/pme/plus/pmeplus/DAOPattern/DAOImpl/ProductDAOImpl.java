package com.pme.plus.pmeplus.DAOPattern.DAOImpl;

import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.ProductDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.ProductMapper;
import com.pme.plus.pmeplus.Entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public class ProductDAOImpl implements ProductDAO, DatasourceDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Connection connection;
    private ProductMapper mapper;

    public void setDataSource(DataSource ds) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.mapper = new ProductMapper();
    }

    public void createProduct(String name, String category) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createProduct( ?, ? ) } ");
            statement.setString(1, name);
            statement.setString(2, category);
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

    public Product getProductByID(int idProduct) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<Product> products = new ArrayList<Product>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getProductByID(?)");
            statement.setInt(1,idProduct);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                products.add(mapper.mapRow(rs, 0));
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
        return products.get(0);
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllProducts()");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                products.add(mapper.mapRow(rs, 0));
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
        return products;
    }

    public void deleteProductByID(int idProduct) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteProductByID( ? ) } ");
            statement.setInt(1, idProduct);
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

    public void updateProductName(int idProduct, String name) {
        List<Product> products = new ArrayList<Product>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateProductName( ?, ? ) } ");
            statement.setInt(1, idProduct);
            statement.setString(2, name);
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
