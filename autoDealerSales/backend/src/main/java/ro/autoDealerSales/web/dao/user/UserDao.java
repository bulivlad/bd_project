package ro.autoDealerSales.web.dao.user;

import ro.autoDealerSales.web.domain.user.User;

/**
 * @author Vlad.Bulimac
 * @since 8/25/2015
 */
public interface UserDao {

    boolean verifyCreditentials();

    boolean isUserAuthenticated();

    User getAuthenticatedUser();

    int authenticateUser(User user);

    int deauthenticateUser(User user);

}
