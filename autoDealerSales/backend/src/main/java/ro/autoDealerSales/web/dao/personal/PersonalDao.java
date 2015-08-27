package ro.autoDealerSales.web.dao.personal;

import java.sql.ResultSet;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface PersonalDao {

    //        Nu e chiar ce trebuie dar merge
    ResultSet getResultSetWithAllPersonalData(String id);

    ResultSet getResultSetWithAllCustomerPreferences(String id);

    ResultSet getResultSetWithAllCustomerPayments(String id);

}
