package ro.autoDealerSales.web.dao.customer;

import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.domain.CustomerPreference;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buli on 12/25/2014.
 */
public class CustomerDaoImpl implements CustomerDao{

    private Customer customer;
    private Connection con;

    public CustomerDaoImpl() {
        DatabaseConnectionManager dbconnection = null;
        try {
            dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomerDaoImpl(Customer customer) {
        this.customer = customer;
        DatabaseConnectionManager dbconnection = null;
        try {
            dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(String id){
        return ResultSetToPojoConverter.getCustomerById(con,id);
    }

    public ArrayList<Customer> getAllCustomers(){
        return ResultSetToPojoConverter.getAllCustomers(con);
    }

    public List<CustomerPreference> getAllCustomerPreferences(){
        return ResultSetToPojoConverter.getAllCustomerPreferences(con);
    }
}
