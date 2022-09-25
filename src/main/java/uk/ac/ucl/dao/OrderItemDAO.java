package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.OrderItem;

/**
 * @author Taobang
 * @create 2022-09-25 21:32
 */
public interface OrderItemDAO {

    int saveOrderItem(OrderItem orderItem);

}
