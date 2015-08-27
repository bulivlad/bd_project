package ro.autoDealerSales.web.servlets;

import ro.autoDealerSales.web.dao.invoice.InvoiceDao;
import ro.autoDealerSales.web.dao.invoice.InvoiceDaoImpl;
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

    String relativePathToView;
    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        relativePathToView = context.getAttribute("relativePathToView").toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InvoiceDao invoiceController = new InvoiceDaoImpl();

        ArrayList<HybridInvoice> hybridInvoiceArrayList = invoiceController.getArrayListWithHybridInvoices();

//        int numberOfInvoicesPaied = invoiceController.getNumberOfInvoicesNotPaidOrUnpaid("paid");
        int numberOfInvoicesUnpaid = invoiceController.getNumberOfInvoicesNotPaidOrUnpaid("unpaid");

        context.setAttribute("hybridInvoiceArrayList", hybridInvoiceArrayList);
        context.setAttribute("numberOfInvoicesUnpaid", numberOfInvoicesUnpaid);

        RequestDispatcher requestDispatcher = context.getRequestDispatcher(relativePathToView+"/invoice/invoices.jsp");
        requestDispatcher.include(req,resp);

    }
}
