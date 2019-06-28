package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.BookService;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");

        BookService bookService = new BookService();
        Book book = bookService.findByBId(bid);

        req.setAttribute("book", book);

        req.getRequestDispatcher("/Home/BookInfo.jsp").forward(req, resp);
    }
}
