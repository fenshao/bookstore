package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");

        new BookService().delete(bid);

        resp.sendRedirect("/bookstore/admin/bookList");
    }
}
