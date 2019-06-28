package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        User user = (User) req.getSession().getAttribute("user");

        if (user.getPassword().equals(password)) {
            user.setPassword(password2);
            new UserService().update(user);
        }


        resp.sendRedirect("/bookstore/Home/login");

    }
}
