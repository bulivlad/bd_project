package ro.autoDealerSales.web.utils;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Buli on 11/26/2014.
 */
public class DatabaseConnectionManager {

    private static volatile DatabaseConnectionManager instance = null;
    private static OracleDataSource ds;
    private final String DB_USERNAME = "bd_user";
    private final String DB_PASSWORD = "passw0rd";
    private final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/pdborcl";

    private DatabaseConnectionManager(){
        try {
            Properties prop = new Properties();
            prop.setProperty("username",DB_USERNAME);
            prop.setProperty("password",DB_PASSWORD);
            prop.setProperty("url",DB_URL);

            ds = new OracleDataSource();
            ds.setUser(prop.getProperty("username"));
            ds.setPassword(prop.getProperty("password"));
            ds.setURL(prop.getProperty("url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnectionManager getInstance(){
        if(instance == null) instance = new DatabaseConnectionManager();
        return instance;
    }

    public Connection getConnection(){

        Connection con = null;

        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}
