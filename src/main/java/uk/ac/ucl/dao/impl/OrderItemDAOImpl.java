package uk.ac.ucl.dao.impl;

import uk.ac.ucl.dao.OrderItemDAO;
import uk.ac.ucl.pojo.OrderItem;

/**
 * @author huang-wt
 * @create 2022-09-25 21:34
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`) values(?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(),
                orderItem.getTotalPriceAmount(), orderItem.getOrderId());
    }
}
