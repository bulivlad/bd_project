package ro.autoDealerSales.web.dao.search;

import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.domain.HybridPerson;

import java.util.ArrayList;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface SearchDao {

    ArrayList<HybridPerson> getResultSetWithNamesForSearchServlet(String searchText);

    ArrayList<CarForSale> getArrayListWithCarsForSearchServlet(String searchText);

}
