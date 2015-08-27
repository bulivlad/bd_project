package ro.autoDealerSales.web.dao.search;

import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.domain.HybridPerson;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 1/11/2015.
 */
public class SearchDaoImpl implements SearchDao{

    private Connection con;

    public SearchDaoImpl() {
        DatabaseConnectionManager dbconnection = null;
        try {
            dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HybridPerson> getResultSetWithNamesForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getResultSetWithNamesForSearchServlet(con,searchText);
    }

    public ArrayList<CarForSale> getArrayListWithCarsForSearchServlet(String searchText){
        return ResultSetToPojoConverter.getArrayListWithCarsForSearchServlet(con,searchText);
    }

}
