package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.person.PersonDao;
import ro.autoDealerSales.web.dao.person.PersonDaoImpl;

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
 * Created by Buli on 1/2/2015.
 */

@WebServlet(name = "DeletePersonServlet", urlPatterns = "/deleteOne")
public class DeletePersonServlet extends HttpServlet {

    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ArrayList<String> sqlStatements = new ArrayList<String>();

        sqlStatements.add("DELETE from customer_payments where customer_id=" + id);
        sqlStatements.add("DELETE from cars_sold where customer_id=" + id);
        sqlStatements.add("DELETE from customer_preferences where customer_id=" + id);
        sqlStatements.add("DELETE from addresses where customer_id=" + id);
        sqlStatements.add("DELETE from customers where customer_id=" + id);

        PersonDao deleteController = new PersonDaoImpl();
        int result = deleteController.deleteInfoInDB(sqlStatements);

        context.setAttribute("sqlResult", result);

        resp.sendRedirect("general");
    }
}
