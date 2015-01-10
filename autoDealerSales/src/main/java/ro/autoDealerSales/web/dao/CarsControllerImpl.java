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

    public ArrayList<CarForSale> getAllCarsForSale(){
        return ResultSetToPojoConverter.getAllCarsForSale(con);
    }

    public CarForSale getCarForSaleById(String id){
        return ResultSetToPojoConverter.getCarForSaleById(con,id);
    }

    public CarFeature getCarFeatureByCarForSaleId(String id){
        return ResultSetToPojoConverter.getCarFeatureByCarForSaleId(con,id);
    }

    public int addInfoIntoDB(ArrayList<String> sqlStrings){
        return DBOperations.add(sqlStrings);
    }
}
