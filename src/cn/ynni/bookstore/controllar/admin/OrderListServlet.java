package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.service.OrdersService;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Orders> orders = new OrdersService().findAll();

        for (Orders or : orders) {
            or.setUser(new UserService().findUserById(or.getUid()));
        }

        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/admin/adminorder.jsp").forward(req, resp);

    }
}
