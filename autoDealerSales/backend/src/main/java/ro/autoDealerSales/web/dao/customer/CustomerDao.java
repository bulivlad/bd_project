package ro.autoDealerSales.web.dao.customer;

import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.domain.CustomerPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface CustomerDao {

    Customer getCustomerById(String id);

    ArrayList<Customer> getAllCustomers();

    List<CustomerPreference> getAllCustomerPreferences();

}
