package uk.ac.ucl.service;

import uk.ac.ucl.pojo.Book;
import uk.ac.ucl.pojo.Page;

import java.util.List;

/**
 * @author Taobang
 * @create 2022-09-23 19:40
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int itemsNumberPerPage);

    Page<Book> pageByPrice(int pageNo, int itemsNumberPerPage, int min, int max);
}
