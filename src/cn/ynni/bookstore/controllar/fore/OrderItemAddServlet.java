package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemAddServlet extends HttpServlet{

    /***********************************************
     1. 获取购买数量
     2. 获取购买商品的id
     3. 根据id获取商品对象
     4. 创建一个新的OrderItem对象
     5. 从session中取出一个List , 这个List里面存放陆续购买的商品。
     如果是第一次从session中获取该List,那么它会是空的，需要创建一个ArrayList
     6. 把新创建的OrderItem对象放入该List 中
     7. 跳转到显示购物车的listOrderItem
     ************************************************/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        int number = Integer.parseInt(req.getParameter("number"));

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

        req.getRequestDispatcher("/Home/Cart.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
