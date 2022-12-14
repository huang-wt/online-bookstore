package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.pojo.Cart;
import uk.ac.ucl.pojo.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author huang-wt
 * @create 2022-09-25 15:14
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();

        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "book01", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        cart.addItem(new CartItem(2, "book02", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.updateCount(2, 10);

        System.out.println(cart);
    }
}