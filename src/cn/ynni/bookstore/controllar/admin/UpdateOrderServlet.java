package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");
        String state = req.getParameter("ustate");
        String address = req.getParameter("address");

        Orders orders = new Orders();

        orders.setPrice(new OrdersService().findById(oid).getPrice());
        orders.setState(Integer.parseInt(state));
        orders.setAddress(address);
        orders.setOid(oid);

        new OrdersService().update(orders);

        resp.sendRedirect("/bookstore/admin/orderList");
    }
}
