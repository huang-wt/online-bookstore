package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.OrderItem;

/**
 * @author huang-wt
 * @create 2022-09-25 21:32
 */
public interface OrderItemDAO {

    /**
     * Insert a specific order item into table t_order_item
     * @param orderItem
     * @return -1 if save unsuccessfully
     */
    int saveOrderItem(OrderItem orderItem);

}
