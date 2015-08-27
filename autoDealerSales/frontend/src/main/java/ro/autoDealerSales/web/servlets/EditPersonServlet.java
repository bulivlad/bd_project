package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.person.PersonDao;
import ro.autoDealerSales.web.dao.person.PersonDaoImpl;
import ro.autoDealerSales.web.domain.*;

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
import java.util.ArrayList;

/**
 * Created by Buli on 1/2/2015.
 */

@WebServlet(name = "EditPersonServlet", urlPatterns = "/editPerson")
public class EditPersonServlet extends HttpServlet {

    ServletContext context;
    Customer cstm = new Customer();
    Address addressCstm = new Address();
    CustomerPreference cstmPref = new CustomerPreference();
    CustomerPayments cstmPay = new CustomerPayments();
    CarSold carSold = new CarSold();
    CarForSale carFS = new CarForSale();
    String relativePathToView;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        context.removeAttribute("allCustomers");
        relativePathToView = context.getAttribute("relativePathToView").toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("update");

        if(action.equals("no")) {
            getData(req, resp, id);
        }
        else{
            saveData(req, resp, id);
            resp.sendRedirect("general");
        }

    }

    private void saveData(HttpServletRequest req, HttpServletResponse resp,String id) {
        ArrayList sqlStatements = new ArrayList();

        String firstName,lastName,email,phone,cstmOther,address,postalCode,town,country,addressOther,cstmPref,payStatus, carFSId,producer,model,price, carSoldOther;
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
        payStatus = req.getParameter("payStatus");
        carFSId = req.getParameter("carFSId");
        producer = req.getParameter("producator");
        model = req.getParameter("modelName");
        price = req.getParameter("agreedPrice");
        carSoldOther = req.getParameter("otherSold").equals("") ? "" : req.getParameter("otherSold");
        payDate = req.getParameter("payDate");
        sellDate = req.getParameter("saleDate");

        sqlStatements.add("UPDATE customers set phone=" + phone + ", email='" + email + "', other='" + cstmOther + "', firstname='" + firstName + "', lastname='" + lastName + "' where customer_id=" + id);
        sqlStatements.add("UPDATE addresses set address='" + address + "', town_city='" + town + "', country='" + country + "', post_code='" + postalCode + "', other='" + addressOther + "' where customer_id=" + id);
        sqlStatements.add("UPDATE customer_preferences set customer_pref_details='" + cstmPref + "' where customer_id=" + id);
        sqlStatements.add("UPDATE customer_payments set payment_status='" + payStatus + "', customer_payment_date=TO_DATE('" + payDate + "','yyyy-MM-dd') where customer_id=" + id);
        sqlStatements.add("UPDATE cars_sold set agreed_price=" + price + ", date_sold=TO_DATE('" + sellDate + "','yyyy-MM-dd'), other_details='" + carSoldOther + "' where customer_id=" + id);

        PersonDao personController = new PersonDaoImpl();
        int result = personController.updateInfoInDB(sqlStatements);

        context.setAttribute("sqlResult", result);


    }

    protected void getData(HttpServletRequest req, HttpServletResponse resp, String id)throws ServletException, IOException{
        //        Nu e chiar ce trebuie dar merge
        PersonDao personalInfo = new PersonDaoImpl();
        ResultSet rs = personalInfo.getResultSetWithAllPersonalDataForUpdate(id);

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

//              CustomerPreference

                cstmPref.setId(rs.getInt("customer_preference_id"));
                cstmPref.setCustomerId(rs.getInt("customer_id"));
                cstmPref.setCarFeatureId(rs.getInt("car_feature_id"));
                cstmPref.setCustomerPrefDetails(rs.getString("customer_pref_details"));

//              CustomerPayments

                cstmPay.setId(rs.getInt("customer_payment_id"));
                cstmPay.setCustomerId(rs.getInt("customer_id"));
                cstmPay.setPaymentStatus(rs.getString("payment_status"));
                cstmPay.setPaymentDate(rs.getDate("customer_payment_date"));

//              CarSold

                carSold.setId(rs.getInt("car_sold_id"));
                carSold.setAgreedPrice(rs.getString("agreed_price"));
                carSold.setCarForSaleId(rs.getInt("car_for_sale_id"));
                carSold.setCustomerId(rs.getInt("customer_id"));
                carSold.setDateSold(rs.getDate("date_sold"));
                carSold.setOtherDetails(rs.getString("carSold_other"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rs = personalInfo.getResultSetWithAllCarsForSaleForUpdate(id);
        try{
            if(rs.next()){
//              CarForSale

                carFS.setId(rs.getInt("car_for_sale_id"));
                carFS.setManufacturerName(rs.getString("manufacturer_name"));
                carFS.setModelName(rs.getString("model_name"));
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

        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView+"/person/editperson.jsp");
        requestDispatcher.include(req,resp);
    }

    private void setRequestAtributes(HttpServletRequest req) {
        req.setAttribute("customer", cstm);
        req.setAttribute("address", addressCstm);
        req.setAttribute("customerPayment", cstmPay);
        req.setAttribute("customerPreference", cstmPref);
        req.setAttribute("carSold",carSold);
        req.setAttribute("carForSale",carFS);
    }
}
