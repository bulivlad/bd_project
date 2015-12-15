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
import java.io.PrintWriter;

/**
 * Created by Buli on 12/23/2014.
 */

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        context.setAttribute("relativePathToView","/WEB-INF/views");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("usernameForm");
        String password = req.getParameter("passwordForm");

        User userFromJspForm = new User(username,password);

        UserDao uc = new UserDaoImpl(userFromJspForm);

        if(uc.verifyCreditentials()) {
            context.setAttribute("user",userFromJspForm);
            if(uc.authenticateUser(userFromJspForm) == 1) {
                resp.sendRedirect("general");
            }
            else{
                PrintWriter out = resp.getWriter();
                String error = "<font color=\"red\">Oops..Database may be down. Please try again !</font>";
                out.println(error);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                requestDispatcher.include(req,resp);
            }
        }
        else {
            PrintWriter out = resp.getWriter();
            String error = "<font color=\"red\">Oops..Seems that your username or password is incorect. Please check again !</font>";
            out.println(error);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.include(req, resp);
        }

    }
}
