package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.service.BookService;
import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> bookList = new BookService().findAll();

        for (Book book : bookList) {
            book.setCategory(new CategoryService().findById(book.getCid()));
        }

        req.setAttribute("bookList", bookList);
        req.setAttribute("categorylist", new CategoryService().findAll());
        req.getRequestDispatcher("/admin/adminbooklist.jsp").forward(req, resp);
    }
}
