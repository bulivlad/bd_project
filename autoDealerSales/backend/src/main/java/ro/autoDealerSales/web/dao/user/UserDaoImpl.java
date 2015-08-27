package ro.autoDealerSales.web.dao.user;

import ro.autoDealerSales.web.domain.user.User;
import ro.autoDealerSales.web.utils.DBOperations;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Buli on 12/23/2014.
 */
public class UserDaoImpl implements UserDao{

    private User user;
    private Connection con;

    public UserDaoImpl() {
        try {
            DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public UserDaoImpl(User user) {
        this.user = user;
        try {
            DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
            this.con = dbconnection.getConnection();
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public boolean verifyCreditentials() {

        ArrayList<User> usersList = ResultSetToPojoConverter.getAllUsers(con);

        for (User userFromList : usersList) {
            if(userFromList.equals(user)) return true;
        }

        return false;
    }

    public boolean isUserAuthenticated(){
        try {
            return ResultSetToPojoConverter.isUserAuthenticated(DatabaseConnectionManager.getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getAuthenticatedUser(){
        try {
            return ResultSetToPojoConverter.getAuthenticatedUser(DatabaseConnectionManager.getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int authenticateUser(User user){
        ArrayList<User> allUsers = null;
        try {
            allUsers = ResultSetToPojoConverter.getAllUsers(DatabaseConnectionManager.getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User u : allUsers) {
            if(u.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())){
                user.setUsername(u.getUsername());
                break;
            }
        }
        String sql = "UPDATE users set authenticated = 1 where username = '"+ user.getUsername()+"'";
        ArrayList<String> sqlStrings = new ArrayList<String>();
        sqlStrings.add(sql);

        return DBOperations.update(sqlStrings);
    }

    public int deauthenticateUser(User user){
        ArrayList<User> allUsers = null;
        try {
            allUsers = ResultSetToPojoConverter.getAllUsers(DatabaseConnectionManager.getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User u : allUsers) {
            if(u.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())){
                user.setUsername(u.getUsername());
                break;
            }
        }
        String sql = "UPDATE users set authenticated = 0 where username = '"+ user.getUsername()+"'";
        ArrayList<String> sqlStrings = new ArrayList<String>();
        sqlStrings.add(sql);

        return DBOperations.update(sqlStrings);
    }
}
