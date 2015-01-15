package ro.autoDealerSales.web.dao;

import ro.autoDealerSales.web.domain.CarFeature;
import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 1/4/2015.
 */
public class CarsControllerImpl {

    private Connection con;

    public CarsControllerImpl() {
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    /**
     * Get all cars for sale
     * @return Array List with all cars for sale
     */
    public ArrayList<CarForSale> getAllCarsForSale(){
        return ResultSetToPojoConverter.getAllCarsForSale(con);
    }

    /**
     * Get car for sale by id
     * @param id - car for sale id
     * @return the Car for sale object
     */
    public CarForSale getCarForSaleById(String id){
        return ResultSetToPojoConverter.getCarForSaleById(con,id);
    }

    /**
     * Get car features by car for sale id
     * @param id car for sale id
     * @return the car feature object
     */
    public CarFeature getCarFeatureByCarForSaleId(String id){
        return ResultSetToPojoConverter.getCarFeatureByCarForSaleId(con,id);
    }

    /**
     * Add information into the database
     * @param sqlStrings - array list with all insert statement
     * @return number of modified rows
     */
    public int addInfoIntoDB(ArrayList<String> sqlStrings){
        return DBOperations.add(sqlStrings);
    }
}
