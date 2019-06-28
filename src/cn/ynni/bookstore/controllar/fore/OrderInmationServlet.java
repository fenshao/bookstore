package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.dao.BookDao;
import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.OrderInfoService;
import cn.ynni.bookstore.service.OrderItemService;
import cn.ynni.bookstore.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderInmationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");

        OrdersService ordersService = new OrdersService();
        Orders orders = ordersService.findById(oid);

        orders.setUser((User)req.getSession().getAttribute("user"));

        //查询订单条目
        OrderItemService orderItemService = new OrderItemService();
        List<Orderitem> orderitems = orderItemService.findByOid(oid);

        //查询书籍条目
        for (Orderitem or : orderitems) {
            try {
                or.setBook(new BookDao().findByBId(or.getBid()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //查询总数
        OrderInfoService orderInfoService = new OrderInfoService();
        int num = orderInfoService.itemCount(oid);

        req.setAttribute("orders", orders);
        req.setAttribute("orderitems", orderitems);
        req.setAttribute("numbers", num);
        req.getRequestDispatcher("/Home/OrderInfo.jsp").forward(req, resp);
    }
}
