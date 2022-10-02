package uk.ac.ucl.web;

import com.google.code.kaptcha.Constants;
import uk.ac.ucl.pojo.User;
import uk.ac.ucl.service.UserService;
import uk.ac.ucl.service.impl.UserServiceImpl;
import uk.ac.ucl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huang-wt
 * @create 2022-09-21 13:33
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()); // to index page
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Null if one or both of the given username and password do not exist or do not match
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            // Fail to log in
            req.setAttribute("msg", "username or password invalid");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        // Request parameters
        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                req.setAttribute("msg", "Username Exists");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "Code Error");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }


}
