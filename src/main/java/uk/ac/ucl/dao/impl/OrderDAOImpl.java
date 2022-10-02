package uk.ac.ucl.dao.impl;

import uk.ac.ucl.dao.OrderDAO;
import uk.ac.ucl.pojo.Order;

/**
 * @author huang-wt
 * @create 2022-09-25 21:34
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) values(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalPriceAmount(),
                order.getStatus(), order.getUserId());
    }
}
