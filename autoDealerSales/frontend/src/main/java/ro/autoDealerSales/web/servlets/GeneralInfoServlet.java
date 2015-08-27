package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.customer.CustomerDaoImpl;
import ro.autoDealerSales.web.domain.Customer;

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

/**
 * Created by Buli on 12/25/2014.
 */

@WebServlet(name = "GeneralInfo", urlPatterns = "/general")
public class GeneralInfoServlet extends HttpServlet {

    ServletContext context;
    String relativePathToView;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        relativePathToView = context.getAttribute("relativePathToView").toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
        req.setAttribute("allCustomers",allCustomers);


        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView+"/info/generalinfo/generalinfo.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
