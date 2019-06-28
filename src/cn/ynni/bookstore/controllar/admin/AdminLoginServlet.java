package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Admin;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.AdminService;
import cn.ynni.bookstore.service.UserService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = new AdminService().findByName(username, password);
        JSONObject object = new JSONObject();

        if (admin != null) { //登录成功
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("admin", admin);
            object.put("success", true);
            object.put("uid", admin.getUid());
        }
        else object.put("success", false);

        resp.getWriter().print(object.toJSONString());
    }
}
