package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.dao.OrderItemDAO;
import uk.ac.ucl.dao.impl.OrderItemDAOImpl;
import uk.ac.ucl.pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Taobang
 * @create 2022-09-25 22:00
 */
public class OrderItemDAOTest {

    @Test
    public void saveOrderItem() {
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

        orderItemDAO.saveOrderItem(new OrderItem(null, "book01", 1, new BigDecimal(80), new BigDecimal(80), "1234567890"));
        orderItemDAO.saveOrderItem(new OrderItem(null, "book03", 2, new BigDecimal(68), new BigDecimal(136), "1234567890"));
    }
}