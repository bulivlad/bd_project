package ro.autoDealerSales.web.domain;

import java.util.Date;

/**
 * Created by Buli on 12/25/2014.
 */
public class CarForSale {

    private Integer id;
    private String manufacturerName;
    private String modelName;
    private String vehicleCategory;
    private Integer askingPrice;
    private Integer currentMileage;
    private Date date_acquired;

    public CarForSale(Integer id, String manufacturerName, String modelName, String vehicleCategory, Integer askingPrice, Integer currentMileage, Date date_acquired) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.vehicleCategory = vehicleCategory;
        this.askingPrice = askingPrice;
        this.currentMileage = currentMileage;
        this.date_acquired = date_acquired;
    }

    public CarForSale(Integer id, String manufacturerName, String modelName, String vehicleCategory) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.vehicleCategory = vehicleCategory;
    }

    public CarForSale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Integer getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(Integer askingPrice) {
        this.askingPrice = askingPrice;
    }

    public Integer getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
    }

    public Date getDate_acquired() {
        return date_acquired;
    }

    public void setDate_acquired(Date date_acquired) {
        this.date_acquired = date_acquired;
    }
}
