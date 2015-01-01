package ro.autoDealerSales.web.utils;

import org.apache.log4j.Logger;
import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Buli on 11/26/2014.
 */
public class ResultSetToPojoConverter {

    static Logger logger = Logger.getLogger(ResultSetToPojoConverter.class.getName());

    public static Customer getCustomerById(Connection con, String id){
        Customer cstm = new Customer();

        PreparedStatement stmt = null;
        String sqlString = "select * from customers where customer_id='" + id + "'";

        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlString);
            rs = stmt.executeQuery();

            if(rs.next()){
                cstm.setId(rs.getInt("customer_id"));
                cstm.setEmail(rs.getString("email"));
                cstm.setFirstName(rs.getString("firstname"));
                cstm.setLastName(rs.getString("lastname"));
                cstm.setOther(rs.getString("other"));
                cstm.setPhone(rs.getLong("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return cstm;
    }

    public static ArrayList<Customer> getAllCustomers(Connection con){

        ArrayList<Customer> customersListFromDB = new ArrayList<Customer>();

        PreparedStatement stmt = null;
        String sqlStatement = "select * from customers ORDER BY customer_id";


        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            while(rs.next()){
                Customer cstm = new Customer();
                cstm.setId(rs.getInt("customer_id"));
                cstm.setEmail(rs.getString("email"));
                cstm.setFirstName(rs.getString("firstname"));
                cstm.setLastName(rs.getString("lastname"));
                cstm.setOther(rs.getString("other"));
                cstm.setPhone(rs.getLong("phone"));

                customersListFromDB.add(cstm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return customersListFromDB;
    }

    public static ArrayList<User> getAllUsers(Connection con){

        ArrayList<User> usersListFromDB = new ArrayList<User>();

        PreparedStatement stmt = null;
        String sqlStatement = "SELECT username, password, AUTHENTICATED FROM users";

        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(sqlStatement);

            logger.debug("DEBUG -> {VerifyLogin} Statement prepared successfully");

            rs = stmt.executeQuery();

            logger.debug("DEBUG -> {VerifyLogin} Query executed successfully");

            while(rs.next()) {
                usersListFromDB.add(new User(rs.getString("username"),rs.getString("password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.getSQLState();
                e.printStackTrace();
            }

        }

        return usersListFromDB;
    }

    public static ResultSet getResultSetWithAllPersonalData(Connection con,String id){
        ResultSet rs = null;

        String sqlStatement = "SELECT c.customer_id, firstname, lastname, phone, email, c.other, address_id, address, town_city,\n" +
                "       country, post_code,a.other as address_other, customer_preference_id, car_feature_id, customer_pref_details,\n" +
                "       customer_payment_id,payment_status,customer_payment_date\n" +
                " from \n" +
                "    customers c join addresses a on (c.customer_id = a.customer_id) \n" +
                "    join customer_preferences cp on (c.customer_id = cp.customer_id)\n" +
                "    join customer_payments cpay on (c.customer_id = cpay.customer_id)\n" +
                " WHERE c.customer_id =" + id;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
