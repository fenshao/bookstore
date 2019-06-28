package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.service.OrderItemService;
import cn.ynni.bookstore.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");

        //先删除Orderitem的记录，再删除order的记录
        OrderItemService orderItemService = new OrderItemService();
        orderItemService.delete(oid);

        //删除orders的记录
        OrdersService ordersService = new OrdersService();
        ordersService.delete(oid);

        resp.sendRedirect("/bookstore/Home/order");
    }
}
