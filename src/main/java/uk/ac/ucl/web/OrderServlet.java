package uk.ac.ucl.web;

import uk.ac.ucl.pojo.Cart;
import uk.ac.ucl.pojo.User;
import uk.ac.ucl.service.OrderService;
import uk.ac.ucl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huang-wt
 * @create 2022-09-25 22:29
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
//        req.setAttribute("orderId", orderId);
        req.getSession().setAttribute("orderId", orderId);

//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}
