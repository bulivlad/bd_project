package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.personal.PersonalDao;
import ro.autoDealerSales.web.dao.personal.PersonalDaoImpl;
import ro.autoDealerSales.web.domain.Address;
import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.domain.CustomerPayments;
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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Buli on 12/27/2014.
 */

@WebServlet(name = "PersonalServlet", urlPatterns = "/personal")
public class PersonalServlet extends HttpServlet {

    ServletContext context;
    Customer cstm = new Customer();
    Address addressCstm = new Address();
    CustomerPreference cstmPref = new CustomerPreference();
    CustomerPayments cstmPay = new CustomerPayments();
    String relativePathToView;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        context.removeAttribute("allCustomers");
        relativePathToView = context.getAttribute("relativePathToView").toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestAtributes(req);

        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView+"/info/personalinfo/personalinfo.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

//        Nu e chiar ce trebuie dar merge
        PersonalDao personalInfo = new PersonalDaoImpl();
        ResultSet rs = personalInfo.getResultSetWithAllPersonalData(id);

        try {
            if (rs.next()) {
//              Customer

                cstm.setId(rs.getInt("customer_id"));
                cstm.setEmail(rs.getString("email"));
                cstm.setFirstName(rs.getString("firstname"));
                cstm.setLastName(rs.getString("lastname"));
                cstm.setOther(rs.getString("other"));
                cstm.setPhone(Long.valueOf(rs.getInt("phone")));

//              Address

                addressCstm.setId(rs.getInt("address_id"));
                addressCstm.setAddress(rs.getString("address"));
                addressCstm.setCustomer_id(rs.getInt("customer_id"));
                addressCstm.setTown(rs.getString("town_city"));
                addressCstm.setCountry(rs.getString("country"));
                addressCstm.setPostalCode(rs.getString("post_code"));
                addressCstm.setOther(rs.getString("address_other"));
            }
        }catch (SQLException e) {
                e.printStackTrace();
        }

        rs = personalInfo.getResultSetWithAllCustomerPreferences(id);
        try{
            if(rs.next()){

//              CustomerPreference

                cstmPref.setId(rs.getInt("customer_preference_id"));
                cstmPref.setCustomerId(rs.getInt("customer_id"));
                cstmPref.setCarFeatureId(rs.getInt("car_feature_id"));
                cstmPref.setCustomerPrefDetails(rs.getString("customer_pref_details"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rs = personalInfo.getResultSetWithAllCustomerPayments(id);
        try{
            if(rs.next()){
//              CustomerPayments

                cstmPay.setId(rs.getInt("customer_payment_id"));
                cstmPay.setCustomerId(rs.getInt("customer_id"));
                cstmPay.setPaymentStatus(rs.getString("payment_status"));
                cstmPay.setPaymentDate(rs.getDate("customer_payment_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setRequestAtributes(req);

        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView+"/info/personalinfo/personalinfo.jsp");
        requestDispatcher.include(req,resp);

    }

    private void setRequestAtributes(HttpServletRequest req){
        req.setAttribute("customer", cstm);
        req.setAttribute("address",addressCstm);
        req.setAttribute("customerPayment",cstmPay);
        req.setAttribute("customerPreference",cstmPref);
    }
}
