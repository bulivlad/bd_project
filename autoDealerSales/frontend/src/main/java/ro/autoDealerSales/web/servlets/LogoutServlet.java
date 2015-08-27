package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.user.UserDao;
import ro.autoDealerSales.web.dao.user.UserDaoImpl;
import ro.autoDealerSales.web.domain.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vlad.Bulimac
 * @since 8/26/2015
 */

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDaoImpl = new UserDaoImpl();

        User currentUser = (User) context.getAttribute("user");
        userDaoImpl.deauthenticateUser(currentUser);

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/index.jsp");
        requestDispatcher.include(req, resp);
    }
}
