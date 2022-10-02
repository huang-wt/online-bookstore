package uk.ac.ucl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import uk.ac.ucl.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author huang-wt
 * @create 2022-09-18 16:10
 */
public abstract class BaseDAO {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * Execute INSERT/UPDATE/DELETE statement
     * @param sql sql statement for inserting new record(s)/update record(s)/delete record(s)
     * @param args required arguments in sql statement
     * @return -1 if unsuccessful execution
     */
    public int update(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return -1;
    }

    /**
     * Execute QUERY
     * @param type bean (record) class type
     * @param sql sql statement for select a record
     * @param args required arguments in sql statement
     * @param <T>
     * @return null if unsuccessful execution or record not found; or the selected record object
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * Execute QUERY for multiple results
     * @param type bean (record) class type
     * @param sql sql statement for select multiple records
     * @param args required arguments in sql statement
     * @param <T>
     * @return null if unsuccessful execution; or a list containing selected record objects
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * Execute QUERY for some scalar value
     * @param sql sql statement for some scalar value (e.g. count)
     * @param args required arguments in sql statement
     * @return null if unsuccessful execution; or required object
     */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

}