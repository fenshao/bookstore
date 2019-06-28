package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActivateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");

        UserService userService = new UserService();
        User user = userService.findUserByCode(code);

        if (user != null && user.getCode().equals(code)) {
            //更改值
            userService.updateState(user);
            req.setAttribute("str", "true");
            req.setAttribute("msg", "注册成功! 即将跳转到登录页面...");
        }
        else {
            req.setAttribute("str", "false");
            req.setAttribute("msg", "激活码有误请重新激活！");
        }

        req.getRequestDispatcher("msg.jsp").forward(req, resp);
    }
}
