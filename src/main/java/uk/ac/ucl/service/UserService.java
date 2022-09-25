package uk.ac.ucl.service;

import uk.ac.ucl.pojo.User;

/**
 * @author Taobang
 * @create 2022-09-18 17:31
 */
public interface UserService {

    /**
     * Register new user Account
     * @param user
     */
    public void registerUser(User user);

    /**
     * Sign in
     * @param user
     * @return null if login unsuccessfully
     */
    public User login(User user);

    /**
     * Check if username is valid (not yet registered)
     * @param username
     * @return true if user with the provided username already exists
     */
    public boolean existUsername(String username);




}
