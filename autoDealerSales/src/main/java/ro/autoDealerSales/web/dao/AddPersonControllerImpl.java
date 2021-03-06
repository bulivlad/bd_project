package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 1/3/2015.
 */
public class AddPersonControllerImpl {

    private Connection con;

    public AddPersonControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    /**
     * Add info into the database
     * @param sqlStrings - Array list with all insert statement
     * @return number of modified rows
     */
    public int addInfoIntoDB(ArrayList<String> sqlStrings){
        return DBOperations.add(sqlStrings);
    }
}
