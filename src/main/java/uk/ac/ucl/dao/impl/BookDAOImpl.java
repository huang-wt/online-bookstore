package uk.ac.ucl.dao.impl;

import uk.ac.ucl.dao.BookDAO;
import uk.ac.ucl.pojo.Book;

import java.util.List;

/**
 * @author huang-wt
 * @create 2022-09-23 19:14
 */
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ?, `author` = ?, `price` = ?, `sales` = ?, `stock` = ?, `img_path` = ? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForBooksTotalNumber() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageBooks(int begin, int itemsNumberPerPage) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?, ?";
        return queryForList(Book.class, sql, begin, itemsNumberPerPage);
    }

    @Override
    public int queryForBooksTotalNumberByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageBooksByPrice(int begin, int itemsNumberPerPage, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath " +
                "from t_book where price between ? and ? order by `price` limit ?, ?";
        return queryForList(Book.class, sql, min, max, begin, itemsNumberPerPage);
    }
}
