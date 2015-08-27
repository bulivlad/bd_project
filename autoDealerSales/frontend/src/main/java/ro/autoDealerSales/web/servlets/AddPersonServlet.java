package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.car.CarDao;
import ro.autoDealerSales.web.dao.car.CarDaoImpl;
import ro.autoDealerSales.web.dao.customer.CustomerDao;
import ro.autoDealerSales.web.dao.customer.CustomerDaoImpl;
import ro.autoDealerSales.web.dao.person.PersonDao;
import ro.autoDealerSales.web.dao.person.PersonDaoImpl;
import ro.autoDealerSales.web.domain.CarForSale;
import ro.autoDealerSales.web.domain.CustomerPreference;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buli on 1/2/2015.
 */

@WebServlet(name = "AddPersonServlet", urlPatterns = "/addOne")
public class AddPersonServlet extends HttpServlet {

    ServletContext context;
    String relativePathToView;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        relativePathToView = context.getAttribute("relativePathToView").toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView + "/person/addperson.jsp");
        List<CustomerPreference> customerPreferenceList;
        List<CarForSale> carForSaleList;
        CustomerDao customerDaoImpl = new CustomerDaoImpl();
        customerPreferenceList = customerDaoImpl.getAllCustomerPreferences();
        CarDao carDaoImpl = new CarDaoImpl();
        carForSaleList = carDaoImpl.getAllCarsForSale();
        req.setAttribute("customerPreferenceList",customerPreferenceList);
        req.setAttribute("carForSaleList",carForSaleList);
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<String> sqlStatements = new ArrayList<String>();

        String firstName,lastName,email,phone,cstmOther,address,postalCode;
        String town,country,addressOther,cstmPref,payStatus, carFSId,producer,model,price, carSoldOther;
        String carFeatureId;
        String payDate,sellDate;

        firstName = req.getParameter("firstName");
        lastName = req.getParameter("lastName");
        email = req.getParameter("email").equals("") ? "" : req.getParameter("email");
        phone = req.getParameter("phone");
        cstmOther = req.getParameter("customerOther").equals("") ? "" : req.getParameter("customerOther");
        address = req.getParameter("address");
        postalCode = req.getParameter("postalCode");
        town = req.getParameter("town");
        country = req.getParameter("country");
        addressOther = req.getParameter("addressOther").equals("") ? "" : req.getParameter("addressOther");
        cstmPref = req.getParameter("preferences").equals("") ? "" : req.getParameter("preferences");
        carFeatureId = req.getParameter("carFeatureId");
        payStatus = req.getParameter("payStatus");
        carFSId = req.getParameter("carFSId");
        producer = req.getParameter("producator");
        model = req.getParameter("modelName");
        price = req.getParameter("agreedPrice");
        carSoldOther = req.getParameter("otherSold").equals("") ? "" : req.getParameter("otherSold");
        payDate = req.getParameter("payDate");
        sellDate = req.getParameter("saleDate");

        sqlStatements.add("INSERT into customers (customer_id, phone,email,other,firstname, lastname) values (increment_customer.nextval, "+ phone + ", '" + email + "', '" + cstmOther + "', '" + firstName + "', '" + lastName + "')");
        sqlStatements.add("INSERT into addresses (address_id, customer_id, address, town_city, country, post_code, other) values (increment_address.nextval, (select max(customer_id) from customers), '" + address + "', '" + town + "', '" + country + "', '" + postalCode + "', '" + addressOther + "')");
        sqlStatements.add("INSERT into customer_preferences (customer_preference_id, car_feature_id, customer_id, customer_pref_details) values (increment_preferences.nextval, " + carFeatureId + ", (select max(customer_id) from customers), '" + cstmPref + "')");
        sqlStatements.add("INSERT into cars_sold (CAR_SOLD_ID, CAR_FOR_SALE_ID, AGREED_PRICE, DATE_SOLD, OTHER_DETAILS, CUSTOMER_ID) values (increment_sold.nextval, " + carFSId + ", " + price + ", TO_DATE('" + sellDate + "','yyyy-dd-MM'), '" + carSoldOther + "', (select max(customer_id) from customers))");
        sqlStatements.add("INSERT into customer_payments (CUSTOMER_PAYMENT_ID, CAR_SOLD_ID, CUSTOMER_ID, PAYMENT_STATUS, CUSTOMER_PAYMENT_DATE) values (increment_payments.nextval, (select max(car_sold_id) from cars_sold), (select max(customer_id) from customers), '" + payStatus + "', TO_DATE('" + payDate + "','yyyy-dd-MM'))");

        PersonDao addController = new PersonDaoImpl();
        int result = addController.addInfoIntoDB(sqlStatements);

        context.setAttribute("sqlResult", result);

        resp.sendRedirect("general");
    }
}
