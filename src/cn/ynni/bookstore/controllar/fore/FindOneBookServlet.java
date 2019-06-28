package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.BookService;
import cn.ynni.bookstore.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindOneBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");

        BookService bookService = new BookService();
        List<Book> books;

        if (cid.equals("")) books = bookService.findAll();
        else books = bookService.findById(cid);

        JSONObject object = new JSONObject();

        object.put("books", JSONArray.parseArray(JSON.toJSONString(books)));

        resp.getWriter().print(object.toJSONString());
    }
}
