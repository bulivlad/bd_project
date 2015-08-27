package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 12/25/2014.
 */
public class Address {

    Integer id;
    Integer customer_id;
    String address;
    String town;
    String country;
    String postalCode;
    String other;

    public Address(Integer id, Integer customer_id, String address, String town, String country, String postalCode, String other) {
        this.id = id;
        this.customer_id = customer_id;
        this.address = address;
        this.town = town;
        this.country = country;
        this.postalCode = postalCode;
        this.other = other;
    }

    public Address(Integer id, Integer customer_id, String address, String town, String country, String postalCode) {
        this.id = id;
        this.customer_id = customer_id;
        this.address = address;
        this.town = town;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
