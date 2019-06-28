package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.BookService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        int number = Integer.parseInt(req.getParameter("number"));

        JSONObject object = new JSONObject();

        User u = (User) req.getSession().getAttribute("user");

        if (u == null) {
            object.put("success", false);
            object.put("msg", "订单创建失败！请先登录。");
            resp.getWriter().print(object.toJSONString());

            return;
        }

        BookService bookService = new BookService();
        Book book = bookService.findByBId(bid);

        Orderitem orderitem = new Orderitem();

        orderitem.setCount(number);
        orderitem.setBook(book);

        List<Orderitem> ois = (List<Orderitem>) req.getSession().getAttribute("ois");

        if (null == ois) {
            ois = new ArrayList<Orderitem>();
            req.getSession().setAttribute("ois", ois);
        }

        boolean found = false;
        for (Orderitem orderItem : ois) {
            if (orderItem.getBook().getBid().equals(orderitem.getBook().getBid())) {
                orderItem.setCount(orderItem.getCount() + orderitem.getCount());
                found = true;
                break;
            }
        }

        if (!found) ois.add(orderitem);


        object.put("success", true);

        resp.getWriter().print(object.toJSONString());
    }
}
