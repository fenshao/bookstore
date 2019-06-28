package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.BookService;
import cn.ynni.bookstore.service.OrderItemService;
import cn.ynni.bookstore.service.OrdersService;
import cn.ynni.bookstore.utils.CodeUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("numbers");
        String bid = req.getParameter("bid");

        //创建订单
        JSONObject object = new JSONObject();

        User u = (User)req.getSession().getAttribute("user");

        if (null == u) {
            object.put("success", false);
            object.put("msg", "订单创建失败！请先登录！");
            resp.getWriter().print(object.toJSONString());
            return;
        }

        Orders orders = new Orders();
        orders.setUser(u);
        orders.setOid(CodeUtil.generateUniqueCode());
        orders.setState(0);
        orders.setOrdertime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        //查询图书
        BookService bookService = new BookService();
        Book book = bookService.findByBId(bid);

        orders.setAddress(u.getAddress());
        orders.setPrice(book.getPrice() * Integer.parseInt(number));

        //插入订单
        OrdersService ordersService = new OrdersService();
        ordersService.add(orders);

        //插入订单条目表
        Orderitem orderitem = new Orderitem();
        orderitem.setBook(book);
        orderitem.setIid(Integer.toString(new OrderItemService().itemCount()) + 1);
        orderitem.setSubtotal(book.getPrice() * Integer.parseInt(number));
        orderitem.setCount(Integer.parseInt(number));
        orderitem.setOrders(orders);

        OrderItemService orderItemService = new OrderItemService();
        orderItemService.add(orderitem);

        object.put("success", true);
        object.put("msg", "订单创建成功！请到订单管理查看！");

        resp.getWriter().print(object.toJSONString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
