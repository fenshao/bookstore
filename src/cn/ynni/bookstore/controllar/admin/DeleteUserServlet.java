package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        new UserService().delete(req.getParameter("uid"));

        resp.sendRedirect("/bookstore/admin/userList");

    }
}
