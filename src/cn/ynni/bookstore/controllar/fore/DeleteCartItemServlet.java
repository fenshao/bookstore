package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteCartItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");

        BookService bookService = new BookService();
        Book book = bookService.findByBId(bid);

        List<Orderitem> ois = (List<Orderitem>) req.getSession().getAttribute("ois");

        if (ois != null) {
            for (int i = 0; i < ois.size(); i++) {
                if (ois.get(i).getBook().getBid().equals(book.getBid())) {
                    ois.remove(i);
                }
            }
        }

        req.getRequestDispatcher("/Home/cart").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
