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

/**
 * @author huang-wt
 * @create 2022-09-25 00:15
 */
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int itemsNumberPerPage = WebUtils.parseInt(req.getParameter("pageSize"), Page.ITEMS_NUMBER_PER_PAGE);

        Page<Book> page = bookService.page(pageNo, itemsNumberPerPage);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int itemsNumberPerPage = WebUtils.parseInt(req.getParameter("pageSize"), Page.ITEMS_NUMBER_PER_PAGE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        Page<Book> page = bookService.pageByPrice(pageNo, itemsNumberPerPage, min, max);
        page.setUrl(sb.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
