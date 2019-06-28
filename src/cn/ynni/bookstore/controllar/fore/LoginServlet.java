package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.BookService;
import cn.ynni.bookstore.service.CategoryService;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findAll();

        BookService bookService = new BookService();
        List<Book> books = bookService.findById("1");

        req.setAttribute("books", books);
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("/Home/Index.jsp").forward(req, resp);
    }
}
