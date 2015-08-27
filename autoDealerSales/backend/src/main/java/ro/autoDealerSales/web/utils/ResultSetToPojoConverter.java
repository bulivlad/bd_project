package ro.autoDealerSales.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.autoDealerSales.web.domain.*;
import ro.autoDealerSales.web.domain.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Buli on 11/26/2014.
 */
public class ResultSetToPojoConverter {

    static Logger logger = LoggerFactory.getLogger(ResultSetToPojoConverter.class.getName());

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
                if(stmt != null) {
                    stmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.getSQLState();
                e.printStackTrace();
            }

        }

        return usersListFromDB;
    }

    public static ResultSet getResultSetWithAllCustomerPreferences(Connection con, String id){
        ResultSet rs = null;

        String sqlStatement = "select c.customer_id, customer_preference_id, car_feature_id, customer_pref_details\n" +
                "       from customers c join customer_preferences cp on (c.customer_id = cp.customer_id)\n" +
                "       where c.customer_id=" + id;

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getResultSetWithAllCustomerPayments(Connection con, String id){
        ResultSet rs = null;

        String sqlStatement = " select c.customer_id, customer_payment_id, payment_status, customer_payment_date\n" +
                "    from customers c join customer_payments cp on (c.customer_id = cp.customer_id)\n" +
                "    where c.customer_id =" + id;

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getResultSetWithAllPersonalData(Connection con,String id){
        ResultSet rs = null;

        String sqlStatement = "SELECT c.customer_id, firstname, lastname, phone, email, c.other, address_id, address, town_city,\n" +
                "       country, post_code,a.other as address_other, \n" +
                "       customer_payment_id,payment_status,customer_payment_date\n" +
                " from \n" +
                "    customers c join addresses a on (c.customer_id = a.customer_id) \n" +
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

    public static ResultSet getResultSetWithAllCarsForSaleForUpdate(Connection con, String id){
        ResultSet rs = null;

        String sqlStatement = "select cfs.car_for_sale_id, manufacturer_name,model_name\n" +
                "from cars_for_sale cfs join cars_sold css on (CFS.CAR_FOR_SALE_ID = CSS.CAR_FOR_SALE_ID)\n" +
                "WHERE css.customer_id =" + id;

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int getNumberOfInvoicesNotPaidOrUnpaid(Connection con, String paidStatus){
        int numberOfInvoices = 0;

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sqlStatement = "SELECT COUNT(cp.payment_status) as counter \n" +
                "    FROM invoices i JOIN customers c ON (i.customer_id = c.customer_id)\n" +
                "                    JOIN cars_sold cs ON (i.car_sold_id = cs.car_sold_id)\n" +
                "                    JOIN customer_payments cp ON (i.customer_payment_id = cp.customer_payment_id),\n" +
                "         cars_sold css JOIN cars_for_sale cfs ON (css.car_for_sale_id = cfs.car_for_sale_id) \n" +
                "    WHERE i.customer_id = css.customer_id and cp.payment_status = '"+ paidStatus +"'";

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            if(rs.next()){
                numberOfInvoices = rs.getInt("counter");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfInvoices;
    }

    public static ArrayList<HybridInvoice> getArrayListWithHybridInvoices(Connection con){
        ArrayList<HybridInvoice> hybridInvoiceArrayList = new ArrayList<HybridInvoice>();

        ResultSet rs = null;

        String sqlStatement = "SELECT c.customer_id, c.firstname, c.lastname, cfs.manufacturer_name, cfs.model_name, cp.payment_status, cs.agreed_price\n" +
                "    FROM invoices i JOIN customers c ON (i.customer_id = c.customer_id)\n" +
                "                    JOIN cars_sold cs ON (i.car_sold_id = cs.car_sold_id)\n" +
                "                    JOIN customer_payments cp ON (i.customer_payment_id = cp.customer_payment_id),\n" +
                "         cars_sold css JOIN cars_for_sale cfs ON (css.car_for_sale_id = cfs.car_for_sale_id) \n" +
                "    WHERE i.customer_id = css.customer_id\n" +
                "    ORDER BY payment_status DESC";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            while(rs.next()){
                HybridInvoice hybridInvoice = new HybridInvoice();

                Customer customer = new Customer();

                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                hybridInvoice.setCustomer(customer);

                CarForSale carForSale = new CarForSale();

                carForSale.setManufacturerName(rs.getString("manufacturer_name"));
                carForSale.setModelName(rs.getString("model_name"));
                hybridInvoice.setCarForSale(carForSale);

                CustomerPayments customerPayments = new CustomerPayments();

                customerPayments.setPaymentStatus(rs.getString("payment_status"));
                hybridInvoice.setCustomerPayments(customerPayments);

                CarSold carSold = new CarSold();

                carSold.setAgreedPrice("agreed_price");
                hybridInvoice.setCarSold(carSold);

                hybridInvoiceArrayList.add(hybridInvoice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hybridInvoiceArrayList;
    }

    public static ArrayList<CarForSale> getArrayListWithCarsForSearchServlet(Connection con, String searchText){
        ResultSet rs = null;

        String sqlStatement = "select cfs.car_for_sale_id, cfs.manufacturer_name, cfs.model_name, cfs.asking_price\n" +
                "    from cars_for_sale cfs \n" +
                "     where \n" +
                "        cfs.manufacturer_name IN (select manufacturer_name from cars_for_sale where LOWER(manufacturer_name) like '%"+ searchText +"%') \n" +
                "         OR \n" +
                "         cfs.model_name IN (select model_name from cars_for_sale where LOWER(model_name) like '%"+ searchText +"%')";

        PreparedStatement stmt = null;

        ArrayList<CarForSale> cars = new ArrayList<CarForSale>();

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            while(rs.next()){
                CarForSale carFromSearch = new CarForSale();

                carFromSearch.setId(rs.getInt("car_for_sale_id"));
                carFromSearch.setManufacturerName(rs.getString("manufacturer_name"));
                carFromSearch.setModelName(rs.getString("model_name"));
                carFromSearch.setAskingPrice(rs.getInt("asking_price"));

                cars.add(carFromSearch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null) stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }

    public static ArrayList<HybridPerson> getResultSetWithNamesForSearchServlet(Connection con, String searchText){
        ResultSet rs = null;

        String sqlStatement = "select c.customer_id, c.lastname,c.firstname, ad.address_id, \n" +
                "    (select a.address from addresses a  where a.customer_id = c.customer_id) as address\n" +
                "    from customers c join addresses ad on(c.customer_id = ad.customer_id)\n" +
                "     where (LOWER(c.firstname) like '%"+ searchText +"%') OR (LOWER(c.lastname) like '%"+ searchText +"%')";

        PreparedStatement stmt = null;

        ArrayList<HybridPerson> hybridPersonArrayList = new ArrayList<HybridPerson>();

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            while(rs.next()){
                Customer customer = new Customer();
                Address address = new Address();

                customer.setId(rs.getInt("customer_id"));
                customer.setLastName(rs.getString("lastname"));
                customer.setFirstName(rs.getString("firstname"));

                address.setId(rs.getInt("address_id"));
                address.setAddress(rs.getString("address"));

                HybridPerson person = new HybridPerson();
                person.setCustomer(customer);
                person.setAddress(address);

                hybridPersonArrayList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hybridPersonArrayList;
    }

    public static ResultSet getResultSetWithAllPersonalDataForUpdate(Connection con,String id){
        ResultSet rs = null;

        String sqlStatement = "SELECT c.customer_id, firstname, lastname, phone, email, c.other, address_id, address, town_city,\n" +
                "                                       country, post_code,a.other as address_other, customer_preference_id, car_feature_id,\n" +
                "                                       customer_pref_details, customer_payment_id,payment_status,customer_payment_date,\n" +
                "                                       cs.car_sold_id, cs.agreed_price, cs.date_sold, cs.OTHER_DETAILS as carsold_other\n" +
                "                                 from\n" +
                "                                   customers c join addresses a on (c.customer_id = a.customer_id)\n" +
                "                                    join customer_preferences cp on (c.customer_id = cp.customer_id)\n" +
                "                                    join customer_payments cpay on (c.customer_id = cpay.customer_id)\n" +
                "                                    join cars_sold cs on (c.customer_id = cs.customer_id)\n" +
                "                                        WHERE c.customer_id =" + id;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Get all cars for sale
     * @param con database connection
     * @return Array List with all cars for sale
     */
    public static ArrayList<CarForSale> getAllCarsForSale(Connection con){
        Set<CarForSale> carForSales = new HashSet<CarForSale>();

        String sqlStatement = "SELECT * from cars_for_sale";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlStatement);
            rs = stmt.executeQuery();

            while(rs.next()){
                CarForSale cfs = new CarForSale();
                cfs.setId(rs.getInt("car_for_sale_id"));
                cfs.setManufacturerName(rs.getString("manufacturer_name"));
                cfs.setModelName(rs.getString("model_name"));
                cfs.setAskingPrice(rs.getInt("asking_price"));
                cfs.setCurrentMileage(rs.getInt("current_mileage"));
                cfs.setVehicleCategory(rs.getString("vehicle_category"));
                cfs.setDate_acquired(rs.getDate("date_acquired"));

                carForSales.add(cfs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<CarForSale>(carForSales);
    }

    /**
     * Get car for sale by id
     * @param con - database connection
     * @param id - car for sale id
     * @return the car for sale object
     */
    public static CarForSale getCarForSaleById(Connection con, String id){
        CarForSale carForSale = new CarForSale();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sqlString = "select * from cars_for_sale where car_for_sale_id =" + id;

        try {
            stmt = con.prepareStatement(sqlString);
            rs = stmt.executeQuery();

            if(rs.next()){
                carForSale.setId(rs.getInt("car_for_sale_id"));
                carForSale.setManufacturerName(rs.getString("manufacturer_name"));
                carForSale.setModelName(rs.getString("model_name"));
                carForSale.setVehicleCategory(rs.getString("vehicle_category"));
                carForSale.setCurrentMileage(rs.getInt("current_mileage"));
                carForSale.setAskingPrice(rs.getInt("asking_price"));
                carForSale.setDate_acquired(rs.getDate("date_acquired"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return carForSale;
    }

    /**
     * Get car featur by car for sale id
     * @param con - database connection
     * @param id - car for sale id
     * @return the car feature object
     */
    public static CarFeature getCarFeatureByCarForSaleId(Connection con, String id){
        CarFeature carFeature = new CarFeature();

        String sqlString = "select CAR_FEATURE_ID, CAR_FEATURE_DESCRIPTION from \n" +
                "    car_features cf join cars_for_sale cfs on (CF.CAR_FEATURE_ID = CFS.CAR_FEATURES_ID)\n" +
                "    \n" +
                "    where cfs.car_for_sale_id = " + id;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlString);
            rs = stmt.executeQuery();

            if(rs.next()){
                carFeature.setId(rs.getInt("car_feature_id"));
                carFeature.setDescription(rs.getString("car_feature_description"));
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

        return carFeature;
    }

    public static List<CustomerPreference> getAllCustomerPreferences(Connection con){
        List<CustomerPreference> customerPreferenceList = new ArrayList<CustomerPreference>();

        String sql = "SELECT CUSTOMER_PREFERENCE_ID,CUSTOMER_PREF_DETAILS FROM CUSTOMER_PREFERENCES";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                CustomerPreference customerPreference = new CustomerPreference();
                customerPreference.setId(rs.getInt("CUSTOMER_PREFERENCE_ID"));
                customerPreference.setCustomerPrefDetails(rs.getString("CUSTOMER_PREF_DETAILS"));
                customerPreferenceList.add(customerPreference);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return customerPreferenceList;
    }

    public static boolean isUserAuthenticated(Connection con){
        String sql = "SELECT USERNAME,PASSWORD,AUTHENTICATED FROM USERS WHERE AUTHENTICATED = 1";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static User  getAuthenticatedUser(Connection con){
        String sql = "SELECT USERNAME,PASSWORD,AUTHENTICATED FROM USERS WHERE AUTHENTICATED = 1";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if(rs.next()){
                return new User(rs.getString("username"),rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
