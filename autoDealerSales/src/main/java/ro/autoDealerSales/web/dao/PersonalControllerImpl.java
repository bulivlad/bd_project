package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Buli on 12/27/2014.
 */
public class PersonalControllerImpl {

    private Connection con;

    public PersonalControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

//        Nu e chiar ce trebuie dar merge
    public ResultSet getResultSetWithAllPersonalData(String id){
        return ResultSetToPojoConverter.getResultSetWithAllPersonalData(con,id);
    }

    public ResultSet getResultSetWithAllCustomerPreferences(String id){
        return ResultSetToPojoConverter.getResultSetWithAllCustomerPreferences(con, id);
    }

    public ResultSet getResultSetWithAllCustomerPayments(String id){
        return ResultSetToPojoConverter.getResultSetWithAllCustomerPayments(con,id);
    }
}
