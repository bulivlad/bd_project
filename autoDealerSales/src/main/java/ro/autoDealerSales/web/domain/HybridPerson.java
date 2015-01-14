package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 1/13/2015.
 */
public class HybridPerson {

    private Customer customer;
    private Address address;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
