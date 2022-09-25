package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.User;

/**
 * @author Taobang
 * @create 2022-09-18 17:08
 */
public interface UserDAO {

    /**
     * Get user by his/her username
     * @param username
     * @return null if username is not yet registered and thus valid
     */
    public User queryUserByUsername(String username);

    /**
     * Get user by his/her username and password
     * @param username
     * @return null if user with provided username and password does not exist
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * Save user information
     * @param user
     * @return -1 if save unsuccessfully
     */
    public int saveUser(User user);


}
