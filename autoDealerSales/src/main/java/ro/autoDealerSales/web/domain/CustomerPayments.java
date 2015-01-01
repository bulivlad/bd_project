package ro.autoDealerSales.web.domain;

import java.util.Date;

/**
 * Created by Buli on 12/25/2014.
 */
public class CustomerPayments {

    Integer id;
    Integer carSoldId;
    Integer customerId;
    String paymentStatus;
    Date paymentDate;

    public CustomerPayments(Integer id, Integer carSoldId, Integer customerId, String paymentStatus, Date paymentDate) {
        this.id = id;
        this.carSoldId = carSoldId;
        this.customerId = customerId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public CustomerPayments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarSoldId() {
        return carSoldId;
    }

    public void setCarSoldId(Integer carSoldId) {
        this.carSoldId = carSoldId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
