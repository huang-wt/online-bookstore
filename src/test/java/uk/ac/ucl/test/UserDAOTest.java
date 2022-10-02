package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.dao.UserDAO;
import uk.ac.ucl.dao.impl.UserDAOImpl;
import uk.ac.ucl.pojo.User;

import static org.junit.Assert.*;

/**
 * @author huang-wt
 * @create 2022-09-18 17:20
 */
public class UserDAOTest {
    UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if (userDAO.queryUserByUsername("admin") == null) {
            System.out.println("valid username!");
        } else {
            System.out.println("username exists!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDAO.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("wrong information");
        } else {
            System.out.println("login successfully");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null, "admin", "123456", "hwt@qq.com")));
    }
}