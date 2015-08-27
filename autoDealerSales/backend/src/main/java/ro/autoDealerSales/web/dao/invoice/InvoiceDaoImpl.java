package ro.autoDealerSales.web.dao.invoice;

import ro.autoDealerSales.web.domain.HybridInvoice;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 1/14/2015.
 */
public class InvoiceDaoImpl implements InvoiceDao{

    private Connection con;

    public InvoiceDaoImpl() {
        DatabaseConnectionManager dbconnection = null;
        try {
            dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ArrayList<HybridInvoice> getArrayListWithHybridInvoices(){
        return ResultSetToPojoConverter.getArrayListWithHybridInvoices(con);
    }

    public int getNumberOfInvoicesNotPaidOrUnpaid(String paidStatus){
        return ResultSetToPojoConverter.getNumberOfInvoicesNotPaidOrUnpaid(con, paidStatus);
    }

}
