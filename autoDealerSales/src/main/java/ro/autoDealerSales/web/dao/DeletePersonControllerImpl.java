package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 1/2/2015.
 */
public class DeletePersonControllerImpl {

    private Connection con;

    public DeletePersonControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public int deleteInfoInDB(ArrayList<String> sqlStrings){
        return DBOperations.delete(sqlStrings);
    }
}
