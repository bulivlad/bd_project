package ro.autoDealerSales.web.dao.invoice;

import ro.autoDealerSales.web.domain.HybridInvoice;

import java.util.ArrayList;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface InvoiceDao {

    ArrayList<HybridInvoice> getArrayListWithHybridInvoices();

    int getNumberOfInvoicesNotPaidOrUnpaid(String paidStatus);

}
