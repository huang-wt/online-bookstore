package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.User;

/**
 * @author huang-wt
 * @create 2022-09-18 17:08
 */
public interface UserDAO {

    /**
     * Select a user from table t_user by his/her username
     * @param username
     * @return null if username is not yet registered (and thus valid to register)
     */
    User queryUserByUsername(String username);

    /**
     * Get user by his/her username and password
     * @param username
     * @return null if user with the given username and password does not exist
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * Save user information
     * @param user
     * @return -1 if save unsuccessfully
     */
    int saveUser(User user);


}
