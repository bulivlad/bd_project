package ro.autoDealerSales.web.dao.person;

import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public class PersonDaoImpl implements PersonDao {

    private Connection con;

    public PersonDaoImpl() {
        DatabaseConnectionManager dbconnection = null;
        try {
            dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add info into the database
     * @param sqlStrings - Array list with all insert statement
     * @return number of modified rows
     */
    public int addInfoIntoDB(ArrayList<String> sqlStrings) {
        return DBOperations.add(sqlStrings);
    }

    public int deleteInfoInDB(ArrayList<String> sqlStrings) {
        return DBOperations.delete(sqlStrings);
    }

    public int updateInfoInDB(ArrayList<String> sqlStrings) {
        return DBOperations.update(sqlStrings);
    }

    public ResultSet getResultSetWithAllPersonalDataForUpdate(String id) {
        return ResultSetToPojoConverter.getResultSetWithAllPersonalDataForUpdate(con, id);
    }

    public ResultSet getResultSetWithAllCarsForSaleForUpdate(String id) {
        return ResultSetToPojoConverter.getResultSetWithAllCarsForSaleForUpdate(con,id);
    }
}
