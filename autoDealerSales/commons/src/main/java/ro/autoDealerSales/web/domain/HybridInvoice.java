package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 1/14/2015.
 */
public class HybridInvoice {

    private Customer customer;
    private CustomerPayments customerPayments;
    private CarForSale carForSale;
    private CarSold carSold;

    public CarSold getCarSold() {
        return carSold;
    }

    public void setCarSold(CarSold carSold) {
        this.carSold = carSold;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerPayments getCustomerPayments() {
        return customerPayments;
    }

    public void setCustomerPayments(CustomerPayments customerPayments) {
        this.customerPayments = customerPayments;
    }

    public CarForSale getCarForSale() {
        return carForSale;
    }

    public void setCarForSale(CarForSale carForSale) {
        this.carForSale = carForSale;
    }
}
