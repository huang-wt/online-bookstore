package uk.ac.ucl.service;

import uk.ac.ucl.pojo.Book;
import uk.ac.ucl.pojo.Page;

import java.util.List;

/**
 * @author huang-wt
 * @create 2022-09-23 19:40
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    /**
     * Page books list and initiate new Page object
     * @param pageNo
     * @param itemsNumberPerPage
     * @return
     */
    Page<Book> page(int pageNo, int itemsNumberPerPage);

    /**
     * Page books list in which price of each book ranges between min and max, and initiate new Page object
     * @param pageNo
     * @param itemsNumberPerPage
     * @param min
     * @param max
     * @return
     */
    Page<Book> pageByPrice(int pageNo, int itemsNumberPerPage, int min, int max);
}
