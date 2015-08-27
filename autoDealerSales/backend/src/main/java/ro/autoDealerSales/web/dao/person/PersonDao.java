package ro.autoDealerSales.web.dao.person;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface PersonDao {

    /**
     * Add info into the database
     * @param sqlStrings - Array list with all insert statement
     * @return number of modified rows
     */
    int addInfoIntoDB(ArrayList<String> sqlStrings);

    /**
     * Delete info from the database
     * @param sqlStrings - Array list with all delete statement
     * @return number of modified rows
     */
    int deleteInfoInDB(ArrayList<String> sqlStrings);

    int updateInfoInDB(ArrayList<String> sqlStrings);

    //        Nu e chiar ce trebuie dar merge
    ResultSet getResultSetWithAllPersonalDataForUpdate(String id);

    ResultSet getResultSetWithAllCarsForSaleForUpdate(String id);

}
