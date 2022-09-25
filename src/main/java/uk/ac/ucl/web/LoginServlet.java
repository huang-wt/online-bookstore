package uk.ac.ucl.web;

import uk.ac.ucl.pojo.User;
import uk.ac.ucl.service.UserService;
import uk.ac.ucl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Taobang
 * @create 2022-09-21 10:32
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Request parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. Check
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) { // fail to log in
            req.setAttribute("msg", "username or password invalid");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
