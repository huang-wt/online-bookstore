package uk.ac.ucl.test;

import org.junit.Test;
import uk.ac.ucl.pojo.Book;
import uk.ac.ucl.pojo.Page;
import uk.ac.ucl.service.BookService;
import uk.ac.ucl.service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Taobang
 * @create 2022-09-23 20:24
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "book22", "author02", new BigDecimal(989), 10, 2, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "bookfortest", "author02", new BigDecimal(989), 10, 2, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.ITEMS_NUMBER_PER_PAGE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.ITEMS_NUMBER_PER_PAGE, 10, 100));
    }
}