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
 * @author huang-wt
 * @create 2022-09-21 10:32
 */
@Deprecated
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Check if the given username and password exist and match
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            // Fail to log in
            req.setAttribute("msg", "username or password invalid");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
