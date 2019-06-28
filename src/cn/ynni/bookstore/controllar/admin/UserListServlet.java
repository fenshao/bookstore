package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();

        List<User> userList = userService.findAll();

        req.setAttribute("userList", userList);

        req.getRequestDispatcher("/admin/adminindex.jsp").forward(req, resp);
    }
}
