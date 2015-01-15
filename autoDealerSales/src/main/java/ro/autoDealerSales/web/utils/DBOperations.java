package ro.autoDealerSales.web.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Buli on 1/2/2015.
 */
public class DBOperations {

    public static int update(ArrayList<String> sqlStrings){
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        Connection con = dbconnection.getConnection();

        PreparedStatement stmt = null;

        int result = 0;

        for (String sqlString : sqlStrings) {
            try {
                stmt = con.prepareStatement(sqlString);
                result = stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int delete(ArrayList<String> sqlStrings){
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        Connection con = dbconnection.getConnection();

        PreparedStatement stmt = null;

        int result = 0;

        for (String sqlString : sqlStrings) {
            try {
                stmt = con.prepareStatement(sqlString);
                result = stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Add informations into the database
     * @param sqlStrings
     * @return number of modified rows
     */
    public static int add(ArrayList<String> sqlStrings){
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        Connection con = dbconnection.getConnection();

        PreparedStatement stmt = null;

        int result = 0;

        for (String sqlString : sqlStrings) {
            try {
                stmt = con.prepareStatement(sqlString);
                result = stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
