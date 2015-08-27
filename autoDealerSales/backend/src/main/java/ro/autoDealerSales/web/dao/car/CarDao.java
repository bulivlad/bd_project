package ro.autoDealerSales.web.dao.car;

import ro.autoDealerSales.web.domain.CarFeature;
import ro.autoDealerSales.web.domain.CarForSale;

import java.util.ArrayList;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface CarDao {

    /**
     * Get all cars for sale
     * @return Array List with all cars for sale
     */
    ArrayList<CarForSale> getAllCarsForSale();

    /**
     * Get car for sale by id
     * @param id - car for sale id
     * @return the Car for sale object
     */
    CarForSale getCarForSaleById(String id);

    /**
     * Get car features by car for sale id
     * @param id car for sale id
     * @return the car feature object
     */
    CarFeature getCarFeatureByCarForSaleId(String id);

    /**
     * Add information into the database
     * @param sqlStrings - array list with all insert statement
     * @return number of modified rows
     */
    int addInfoIntoDB(ArrayList<String> sqlStrings);

}
