package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 12/25/2014.
 */
public class Customer {

    Integer id;
    Long phone;
    String email;
    String other;
    String firstName;
    String lastName;

    public Customer(Integer id, Long phone, String email, String other, String firstName, String lastName) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.other = other;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Integer id, Long phone, String firstName, String lastName) {
        this.id = id;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
