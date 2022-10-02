package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.dao.BookDAO;
import uk.ac.ucl.dao.impl.BookDAOImpl;
import uk.ac.ucl.pojo.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author huang-wt
 * @create 2022-09-23 19:26
 */
public class BookDAOTest {

    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null, "book21", "author01", new BigDecimal(999), 1000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21, "bookfortest", "author01", new BigDecimal(999), 1000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookDAO.queryBooks().forEach(System.out::println);
    }

    @Test
    public void queryForBooksTotalNumber() {
        System.out.println(bookDAO.queryForBooksTotalNumber());
    }

    @Test
    public void queryForPageBooks() {
        bookDAO.queryForPageBooks(8, 4).forEach(System.out::println);
    }

    @Test
    public void queryForBooksTotalNumberByPrice() {
        System.out.println(bookDAO.queryForBooksTotalNumberByPrice(10, 100));
    }

    @Test
    public void queryForPageBooksByPrice() {
        bookDAO.queryForPageBooksByPrice(0, 4, 10, 100).forEach(System.out::println);
    }
}