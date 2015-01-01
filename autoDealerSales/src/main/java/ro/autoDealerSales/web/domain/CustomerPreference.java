package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 12/25/2014.
 */
public class CustomerPreference {

    Integer id;
    Integer carFeatureId;
    Integer customerId;
    String customerPrefDetails;

    public CustomerPreference(Integer id, Integer carFeatureId, Integer customerId, String customerPrefDetails) {
        this.id = id;
        this.carFeatureId = carFeatureId;
        this.customerId = customerId;
        this.customerPrefDetails = customerPrefDetails;
    }

    public CustomerPreference(Integer id, Integer carFeatureId, Integer customerId) {
        this.id = id;
        this.carFeatureId = carFeatureId;
        this.customerId = customerId;
    }

    public CustomerPreference() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarFeatureId() {
        return carFeatureId;
    }

    public void setCarFeatureId(Integer carFeatureId) {
        this.carFeatureId = carFeatureId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPrefDetails() {
        return customerPrefDetails;
    }

    public void setCustomerPrefDetails(String customerPrefDetails) {
        this.customerPrefDetails = customerPrefDetails;
    }
}
