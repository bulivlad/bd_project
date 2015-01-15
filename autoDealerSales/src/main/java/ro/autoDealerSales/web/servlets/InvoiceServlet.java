package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.InvoiceControllerImpl;
import ro.autoDealerSales.web.domain.HybridInvoice;

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
 * Created by Buli on 1/14/2015.
 */

@WebServlet(name = "InvoiceServlet", urlPatterns = "/invoice")
public class InvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InvoiceControllerImpl invoiceController = new InvoiceControllerImpl();

        ArrayList<HybridInvoice> hybridInvoiceArrayList = invoiceController.getArrayListWithHybridInvoices();

//        int numberOfInvoicesPaied = invoiceController.getNumberOfInvoicesNotPaidOrUnpaid("paid");
        int numberOfInvoicesUnpaid = invoiceController.getNumberOfInvoicesNotPaidOrUnpaid("unpaid");

        getServletContext().setAttribute("hybridInvoiceArrayList",hybridInvoiceArrayList);
        getServletContext().setAttribute("numberOfInvoicesUnpaid",numberOfInvoicesUnpaid);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/invoices.jsp");
        requestDispatcher.include(req,resp);

    }
}
