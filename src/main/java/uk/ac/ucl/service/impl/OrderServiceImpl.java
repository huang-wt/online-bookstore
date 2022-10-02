package uk.ac.ucl.service.impl;

import uk.ac.ucl.dao.BookDAO;
import uk.ac.ucl.dao.OrderDAO;
import uk.ac.ucl.dao.OrderItemDAO;
import uk.ac.ucl.dao.impl.BookDAOImpl;
import uk.ac.ucl.dao.impl.OrderDAOImpl;
import uk.ac.ucl.dao.impl.OrderItemDAOImpl;
import uk.ac.ucl.pojo.*;
import uk.ac.ucl.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author huang-wt
 * @create 2022-09-25 22:07
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // Generate order id (combination of current time and user id)
        String orderId = System.currentTimeMillis() + "" + userId;

        Order order = new Order(orderId, new Date(), cart.getTotalPriceAmount(), 0, userId);
        orderDAO.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(),
                    cartItem.getTotalPriceAmount(), orderId);
            orderItemDAO.saveOrderItem(orderItem);

            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
