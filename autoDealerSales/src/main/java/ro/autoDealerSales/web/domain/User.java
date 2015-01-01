package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 12/23/2014.
 */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(username.toLowerCase().equals(((User) obj).getUsername().toLowerCase()) && password.equals(((User) obj).getPassword())) return true;

        return false;
    }
}
