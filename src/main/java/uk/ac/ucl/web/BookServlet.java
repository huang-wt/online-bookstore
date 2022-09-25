package uk.ac.ucl.web;

import uk.ac.ucl.pojo.Book;
import uk.ac.ucl.pojo.Page;
import uk.ac.ucl.service.BookService;
import uk.ac.ucl.service.impl.BookServiceImpl;
import uk.ac.ucl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Taobang
 * @create 2022-09-23 20:31
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int itemsNumberPerPage = WebUtils.parseInt(req.getParameter("pageSize"), Page.ITEMS_NUMBER_PER_PAGE);
        Page<Book> page = bookService.page(pageNo, itemsNumberPerPage);
        page.setUrl("manage/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Get attributes
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        // 2. Call bookService.addBook()
        bookService.addBook(book);

        // 3. Dispatch to Book Management page
//        req.getRequestDispatcher("/manage/bookServlet?action=list").forward(req, resp); //from webapp
        resp.sendRedirect(req.getContextPath() + "/manage/bookServlet?action=page&pageNo=" + pageNo); //from port number
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manage/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manage/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Get the books list by calling bookService.queryBooks()
        List<Book> books = bookService.queryBooks();

        // 2. Set request attribute
        req.setAttribute("books", books);

        // 3. Dispatch to /pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

}
