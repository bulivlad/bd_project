package ro.autoDealerSales.web.dao;

import org.apache.log4j.Logger;
import ro.autoDealerSales.web.domain.User;
import ro.autoDealerSales.web.utils.DatabaseConnectionManager;
import ro.autoDealerSales.web.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Buli on 12/23/2014.
 */
public class UserControllerImpl{

    private User user;
    private Connection con;

    public UserControllerImpl(User user) {
        this.user = user;
        DatabaseConnectionManager dbconnection = DatabaseConnectionManager.getInstance();
        this.con = dbconnection.getConnection();
    }

    public boolean verifyCreditentials() {

        ArrayList<User> usersList = ResultSetToPojoConverter.getAllUsers(con);

        for (User userFromList : usersList) {
            if(userFromList.equals(user)) return true;
        }

        return false;
    }
}
