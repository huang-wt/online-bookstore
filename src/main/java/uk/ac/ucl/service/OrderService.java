package uk.ac.ucl.service;

import uk.ac.ucl.pojo.Cart;

/**
 * @author huang-wt
 * @create 2022-09-25 22:06
 */
public interface OrderService {

    /**
     * Generate order from the cart
     * @param cart
     * @param userId
     * @return order id
     */
    String createOrder(Cart cart, Integer userId);

}
