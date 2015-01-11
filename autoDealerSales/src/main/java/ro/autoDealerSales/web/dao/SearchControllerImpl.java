package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Buli on 1/11/2015.
 */
public class SearchControllerImpl {

    private Connection con;

    public SearchControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public ResultSet getResultSetWithNamesForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getResultSetWithNamesForSearchServlet(con,searchText);
    }

    public ResultSet getResultSetWithCarsForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getResultSetWithCarsForSearchServlet(con,searchText);
    }

}
