package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.pojo.User;
import uk.ac.ucl.service.UserService;
import uk.ac.ucl.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author huang-wt
 * @create 2022-09-18 17:52
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "bbj168", "666666", "bbj168@gmail.com"));
        userService.registerUser(new User(null, "csj168", "666666", "csj168@gmail.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "wzg168", "666666", "wzj168@gmail.com")));
        System.out.println(userService.login(new User(null, "csj168", "666666", "csj168@gmail.com")));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("csj168")) {
            System.out.println("username already exists");
        } else {
            System.out.println("username viable");
        }
    }
}