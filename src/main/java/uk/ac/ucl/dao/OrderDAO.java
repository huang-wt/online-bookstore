package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.Order;

/**
 * @author huang-wt
 * @create 2022-09-25 21:30
 */
public interface OrderDAO {

    /**
     * Insert a specific order into table t_order
     * @param order
     * @return -1 if save unsuccessfully
     */
    int saveOrder(Order order);

}
