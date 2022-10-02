package uk.ac.ucl.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huang-wt
 * @create 2022-09-18 15:20
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    // location: Online-Book-Store-Web-Application/src/main/resources/jdbc.properties
    private static InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

    static {
        try {
//            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
//            System.out.println("successfully loading...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get connection from connection pool
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Close connection
     * @param conn
     */
    public static void close(Connection conn) {
        DbUtils.closeQuietly(conn);
    }

}
