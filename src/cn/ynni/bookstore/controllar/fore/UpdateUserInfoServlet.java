package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String uid = req.getParameter("uid");

        User user = null;

        user = new UserService().findUserById(uid);

        user.setUsername(username);
        user.setEmail(email);
        user.setAddress(address);

        req.getSession().setAttribute("user", user);

        resp.sendRedirect("/bookstore/Home/login");
    }
}
