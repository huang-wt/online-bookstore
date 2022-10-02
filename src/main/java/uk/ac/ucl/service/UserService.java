package uk.ac.ucl.service;

import uk.ac.ucl.pojo.User;

/**
 * @author huang-wt
 * @create 2022-09-18 17:31
 */
public interface UserService {

    /**
     * Register new user account
     * @param user
     */
    void registerUser(User user);

    /**
     * Sign in
     * @param user
     * @return null if login unsuccessfully
     */
    User login(User user);

    /**
     * Check if username is valid (not yet registered)
     * @param username
     * @return true if user with the provided username already exists
     */
    boolean existUsername(String username);




}
