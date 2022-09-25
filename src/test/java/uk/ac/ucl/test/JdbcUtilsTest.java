package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author Taobang
 * @create 2022-09-18 15:47
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
