package uk.ac.ucl.service;

import uk.ac.ucl.pojo.Cart;

/**
 * @author Taobang
 * @create 2022-09-25 22:06
 */
public interface OrderService {

    String createOrder(Cart cart, Integer userId);

}
