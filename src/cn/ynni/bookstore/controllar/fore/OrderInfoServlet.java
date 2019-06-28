package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.OrderInfo;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.OrderInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/index.jsp");
            return;
        }

        //通过user查询订单 通过订单编号查询订单条目
        OrderInfoService orderInfoService = new OrderInfoService();
        List<OrderInfo> orderInfos = orderInfoService.findAll(user);

        req.setAttribute("ordersItem", orderInfos);

        req.getRequestDispatcher("/Home/Order.jsp").forward(req, resp);
    }
}
