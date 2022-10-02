package uk.ac.ucl.service.impl;

import uk.ac.ucl.dao.BookDAO;
import uk.ac.ucl.dao.impl.BookDAOImpl;
import uk.ac.ucl.pojo.Book;
import uk.ac.ucl.pojo.Page;
import uk.ac.ucl.service.BookService;

import java.util.List;

/**
 * @author huang-wt
 * @create 2022-09-23 19:43
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int itemsNumberPerPage) {
        Page page = new Page<Book>();

        page.setItemsNumberPerPage(itemsNumberPerPage);

        int booksTotalNumber = bookDAO.queryForBooksTotalNumber();
        page.setItemsTotalNumber(booksTotalNumber);

        int pagesTotalNumber = booksTotalNumber / itemsNumberPerPage;
        if (booksTotalNumber % itemsNumberPerPage > 0) {
            pagesTotalNumber++;
        }
        page.setPagesTotalNumber(pagesTotalNumber);

        page.setPageNo(pageNo);

        int begin = (pageNo - 1) * itemsNumberPerPage;
        List<Book> books = bookDAO.queryForPageBooks(begin, itemsNumberPerPage);
        page.setItems(books);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int itemsNumberPerPage, int min, int max) {
        Page page = new Page<Book>();

        page.setItemsNumberPerPage(itemsNumberPerPage);

        int booksTotalNumber = bookDAO.queryForBooksTotalNumberByPrice(min, max);
        page.setItemsTotalNumber(booksTotalNumber);

        int pagesTotalNumber = booksTotalNumber / itemsNumberPerPage;
        if (booksTotalNumber % itemsNumberPerPage > 0) {
            pagesTotalNumber++;
        }
        page.setPagesTotalNumber(pagesTotalNumber);

        page.setPageNo(pageNo);

        int begin = (pageNo - 1) * itemsNumberPerPage;
        List<Book> books = bookDAO.queryForPageBooksByPrice(begin, itemsNumberPerPage, min, max);
        page.setItems(books);

        return page;
    }
}
