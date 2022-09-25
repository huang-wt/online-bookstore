package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.Book;

import java.util.List;

/**
 * @author Taobang
 * @create 2022-09-23 19:04
 */
public interface BookDAO {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForBooksTotalNumber();

    List<Book> queryForPageBooks(int begin, int itemsNumberPerPage);

    int queryForBooksTotalNumberByPrice(int min, int max);

    List<Book> queryForPageBooksByPrice(int begin, int itemsNumberPerPage, int min, int max);
}
