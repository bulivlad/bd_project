package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 12/25/2014.
 */
public class CustomerControllerImpl {

    private Customer customer;
    private Connection con;

    public CustomerControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public CustomerControllerImpl(Customer customer) {
        this.customer = customer;
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public Customer getCustomerById(String id){
        return ResultSetToPojoConverter.getCustomerById(con,id);
    }

    public ArrayList<Customer> getAllCustomers(){
        return ResultSetToPojoConverter.getAllCustomers(con);
    }
}
