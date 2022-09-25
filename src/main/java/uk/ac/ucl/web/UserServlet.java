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
 * @author Taobang
 * @create 2022-09-21 13:33
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * Process login event
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * Process register event
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        // 1. Request parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 2. Check
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
//                System.out.println(1);
                req.setAttribute("msg", "Username Exists");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
//                System.out.println(2);
                userService.registerUser(user);
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
