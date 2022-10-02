package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.dao.OrderDAO;
import uk.ac.ucl.dao.impl.OrderDAOImpl;
import uk.ac.ucl.pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author huang-wt
 * @create 2022-09-25 21:44
 */
public class OrderDAOTest {

    @Test
    public void saveOrder() {

        OrderDAO orderDAO = new OrderDAOImpl();

        orderDAO.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 1));

    }
}