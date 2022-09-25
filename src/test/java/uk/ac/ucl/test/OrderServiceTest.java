package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.pojo.Cart;
import uk.ac.ucl.pojo.CartItem;
import uk.ac.ucl.service.OrderService;
import uk.ac.ucl.service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Taobang
 * @create 2022-09-25 22:23
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart, 1));
    }
}