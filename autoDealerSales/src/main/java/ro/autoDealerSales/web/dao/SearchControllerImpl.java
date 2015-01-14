package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.domain.HybridPerson;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Buli on 1/11/2015.
 */
public class SearchControllerImpl {

    private Connection con;

    public SearchControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public ArrayList<HybridPerson> getResultSetWithNamesForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getResultSetWithNamesForSearchServlet(con,searchText);
    }

    public ArrayList<CarForSale> getArrayListWithCarsForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getArrayListWithCarsForSearchServlet(con,searchText);
    }

}
