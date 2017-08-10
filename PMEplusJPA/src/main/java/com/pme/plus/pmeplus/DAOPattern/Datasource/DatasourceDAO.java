package com.pme.plus.pmeplus.DAOPattern.Datasource;

import javax.sql.DataSource;

/**
 * Created by gnkali on 6/20/17.
 */
public interface DatasourceDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
}
