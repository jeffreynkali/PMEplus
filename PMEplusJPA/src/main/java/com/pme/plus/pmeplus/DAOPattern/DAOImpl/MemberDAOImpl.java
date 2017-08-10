package com.pme.plus.pmeplus.DAOPattern.DAOImpl;



/**
 * Created by gnkali on 6/15/17.
 */
import com.pme.plus.pmeplus.DAOPattern.Datasource.DatasourceDAO;
import com.pme.plus.pmeplus.DAOPattern.DAO.MemberDAO;
import com.pme.plus.pmeplus.DAOPattern.Mapping.MemberMapper;
import com.pme.plus.pmeplus.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberDAOImpl implements MemberDAO, DatasourceDAO {

    private boolean initialized = false;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionDefinition def;
    private Connection connection;
    private MemberMapper mapper;

    private void initialize () {
        if (! initialized){
            this.def = new DefaultTransactionDefinition();
            this.mapper = new MemberMapper();
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void createMember(final String firstname, final String lastname, final String email) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.createMember( ?, ?, ? ) } ");
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Member getMemberByID(int idMember) {
        //TODO : properly retrieve the only element that this method should return instead of using a list.
        initialize();
        List<Member> members = new ArrayList<Member>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            // Procedure call.
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getMemberByID(?)");
            statement.setInt(1,idMember);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                members.add(mapper.mapRow(rs, 0));
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
        //the method should return null if no member with that ID was found
        if (members.size() ==  0) {
            return null;
        }
        return members.get(0);
    }

    public List<Member> getMembers() {
        initialize();
        List<Member> members = new ArrayList<Member>();
        try {
            connection = dataSource.getConnection();
            // We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from PMEplus.getAllMembers()");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                members.add(mapper.mapRow(rs, 0));
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
        return members;
    }

    public void deleteMemberByID(int idMember) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.deleteMemberByID( ? ) } ");
            statement.setInt(1, idMember);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateMemberEmail(int idMember, String email) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateMemberEmail( ?, ? ) } ");
            statement.setInt(1, idMember);
            statement.setString(2, email);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateMemberFirstname(int idMember, String firstname) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateMemberFirstname( ?, ? ) } ");
            statement.setInt(1, idMember);
            statement.setString(2, firstname);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateMemberLastname(int idMember, String lastname) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateMemberLastname( ?, ? ) } ");
            statement.setInt(1, idMember);
            statement.setString(2, lastname);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void updateMemberByID(int idMember, String firstname, String lastname, String email) {
        initialize();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            connection = dataSource.getConnection();
            // Procedure call.
            CallableStatement statement = connection.prepareCall(" { call PMEplus.updateMemberByID( ?, ?, ?, ? ) } ");
            statement.setInt(1, idMember);
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setString(4, email);
            statement.execute();
            statement.close();
            transactionManager.commit(status);
        } catch (SQLException e) {
            transactionManager.rollback(status);
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
