package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.Order;

/**
 * @author Taobang
 * @create 2022-09-25 21:30
 */
public interface OrderDAO {

    int saveOrder(Order order);

}
