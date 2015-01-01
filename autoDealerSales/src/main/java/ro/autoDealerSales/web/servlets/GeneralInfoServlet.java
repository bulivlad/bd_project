package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.CustomerControllerImpl;
import ro.autoDealerSales.web.domain.Customer;
import ro.autoDealerSales.web.domain.User;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Buli on 12/25/2014.
 */

@WebServlet(name = "GeneralInfo", urlPatterns = "/general")
public class GeneralInfoServlet extends HttpServlet {

    ServletContext context;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Customer> allCustomers = new CustomerControllerImpl().getAllCustomers();
        req.setAttribute("allCustomers",allCustomers);

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/generalinfo.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
