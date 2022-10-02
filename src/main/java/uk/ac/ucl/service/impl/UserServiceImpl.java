package uk.ac.ucl.service.impl;

import uk.ac.ucl.dao.UserDAO;
import uk.ac.ucl.dao.impl.UserDAOImpl;
import uk.ac.ucl.pojo.User;
import uk.ac.ucl.service.UserService;

/**
 * @author huang-wt
 * @create 2022-09-18 17:49
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null) {
            return false;
        }

        return true;
    }
}
