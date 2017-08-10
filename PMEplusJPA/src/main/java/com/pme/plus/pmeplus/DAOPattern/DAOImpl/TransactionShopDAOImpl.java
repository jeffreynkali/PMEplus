package com.pme.plus.pmeplus.DAOPattern.DAOImpl;

import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.TransactionShopDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.TransactionShopMapper;
import com.pme.plus.pmeplus.Entity.TransactionShop;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public class TransactionShopDAOImpl implements TransactionShopDAO, DatasourceDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Connection connection;
    private TransactionShopMapper mapper;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.mapper = new TransactionShopMapper();
    }

    public void createTransactionShop(TransactionShop transactionShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createTransactionShop( ?, ?, ?, ? ) } ");
            statement.setInt(1, transactionShop.getId().getIdProduct());
            statement.setInt(2, transactionShop.getId().getIdShop());
            statement.setInt(3, transactionShop.getId().getIdMember());
            statement.setInt(4, transactionShop.getQuantity());
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

    public TransactionShop getTransactionShopByIDs(int idProduct, int idShop, int idMember, Date transactionTimestamp) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<TransactionShop> transactionShops = new ArrayList<TransactionShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getTransactionShopByIDs(?, ?, ?, ?)");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.setInt(3, idMember);
            statement.setDate(4, transactionTimestamp);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                transactionShops.add(mapper.mapRow(rs, 0));
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
        return transactionShops.get(0);
    }

    public List<TransactionShop> listTransactionShops() {
        List<TransactionShop> transactionShops = new ArrayList<TransactionShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllTransactionShops() ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                transactionShops.add(mapper.mapRow(rs, 0));
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
        return transactionShops;
    }

    public void deleteTransactionShopByIDs(int idProduct, int idShop, int idMember, Date transactionTimestamp) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteTransactionShopByIDs( ?, ?, ?, ? ) } ");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.setInt(3, idMember);
            statement.setDate(4, transactionTimestamp);
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

    public void updateTransactionShopQuantity(int idProduct, int idShop, int idMember, Date transactionTimestamp, int quantity) {
        List<TransactionShop> transactionShops = new ArrayList<TransactionShop>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateTransactionShopQuantity( ?, ?, ?, ?, ? ) } ");
            statement.setInt(1, idProduct);
            statement.setInt(2, idShop);
            statement.setInt(3, idMember);
            statement.setDate(4, transactionTimestamp);
            statement.setInt(5, quantity);
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
