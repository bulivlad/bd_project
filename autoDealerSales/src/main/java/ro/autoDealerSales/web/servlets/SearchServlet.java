package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.SearchControllerImpl;

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
import java.util.ArrayList;

/**
 * Created by Buli on 1/11/2015.
 */

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultSet rs = null;

        String searchText = req.getParameter("search_text");

        SearchControllerImpl searchController = new SearchControllerImpl();
        //TODO de prelucrat resultset-urile
        rs = searchController.getResultSetWithNamesForSearchServlet(searchText);


        rs = searchController.getResultSetWithCarsForSearchServlet(searchText);



        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/search.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
