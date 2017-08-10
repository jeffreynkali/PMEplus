package com.pme.plus.pmeplus.DAOPattern.DAOImpl;

import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.MemberShopDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.MemberShopMapper;
import com.pme.plus.pmeplus.Entity.MemberShop;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public class MemberShopDAOImpl implements MemberShopDAO, DatasourceDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Connection connection;
    private MemberShopMapper mapper;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.mapper = new MemberShopMapper();
    }

    public void createMemberShop(MemberShop memberShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createMemberShop( ?, ?, ?, ?) } ");
            statement.setInt(1, memberShop.getId().getIdMember());
            statement.setInt(2, memberShop.getId().getIdShop());
            statement.setString(3, memberShop.getCardNumber());
            statement.setLong(4, memberShop.getPoints());
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

    public MemberShop getMemberShopByID(int idMember, int idShop) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<MemberShop> memberShops = new ArrayList<MemberShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getMemberShopByIDs(?, ?)");
            statement.setInt(1, idMember);
            statement.setInt(2, idShop);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                memberShops.add(mapper.mapRow(rs, 0));
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
        return memberShops.get(0);
    }

    public MemberShop getMemberShopByCardNumber(String cardNumber) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        List<MemberShop> memberShops = new ArrayList<MemberShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getMemberShopByCardNumber(?)");
            statement.setString(1, cardNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                memberShops.add(mapper.mapRow(rs, 0));
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
        return memberShops.get(0);
    }

    public List<MemberShop> listMemberShops() {
        List<MemberShop> memberShops = new ArrayList<MemberShop>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllMemberShops() ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                memberShops.add(mapper.mapRow(rs, 0));
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
        return memberShops;
    }

    public void deleteMemberShopByIDs(int idMember, int idShop) {
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteMemberShopByIDs( ?, ?) } ");
            statement.setInt(1, idMember);
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

    public void updateMemberShopPoints(int idMember, int idShop, long points) {
        List<MemberShop> memberShops = new ArrayList<MemberShop>();
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateMemberShopPoints( ?, ?, ? ) } ");
            statement.setInt(1, idMember);
            statement.setInt(2, idShop);
            statement.setLong(3, points);
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
