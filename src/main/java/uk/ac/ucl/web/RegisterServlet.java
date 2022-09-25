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
 * @create 2022-09-18 18:20
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Request parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 2. Check
        if ("ab".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
//                System.out.println(1);
                req.setAttribute("msg", "Username Exists");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
//                System.out.println(2);
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
            }
        } else {
//            System.out.println(3);
            req.setAttribute("msg", "Code Error");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }
}
