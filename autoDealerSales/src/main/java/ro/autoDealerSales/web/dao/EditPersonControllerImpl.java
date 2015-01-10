package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Buli on 1/2/2015.
 */
public class EditPersonControllerImpl {

    private Connection con;

    public EditPersonControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public int updateInfoInDB(ArrayList<String> sqlStrings){
        return DBOperations.update(sqlStrings);
    }

//        Nu e chiar ce trebuie dar merge
    public ResultSet getResultSetWithAllPersonalDataForUpdate(String id){
        return ResultSetToPojoConverter.getResultSetWithAllPersonalDataForUpdate(con, id);
    }
}
