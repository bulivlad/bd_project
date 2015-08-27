package ro.autoDealerSales.web.domain;

import java.util.Date;

/**
 * Created by Buli on 12/25/2014.
 */
public class CarSold {

    Integer id;
    Integer carForSaleId;
    String agreedPrice;
    Date dateSold;
    String otherDetails;
    Integer customerId;

    public CarSold(Integer id, Integer carForSaleId, String agreedPrice, Date dateSold, String otherDetails, Integer customerId) {
        this.id = id;
        this.carForSaleId = carForSaleId;
        this.agreedPrice = agreedPrice;
        this.dateSold = dateSold;
        this.otherDetails = otherDetails;
        this.customerId = customerId;
    }

    public CarSold(Integer id, Integer carForSaleId, Integer customerId) {
        this.id = id;
        this.carForSaleId = carForSaleId;
        this.customerId = customerId;
    }

    public CarSold() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarForSaleId() {
        return carForSaleId;
    }

    public void setCarForSaleId(Integer carForSaleId) {
        this.carForSaleId = carForSaleId;
    }

    public String getAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(String agreedPrice) {
        this.agreedPrice = agreedPrice;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
