package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DoLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        User user = userService.dologin(username);
        JSONObject object = new JSONObject();

        if (user != null && user.getPassword().equals(password)) { //登录成功
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("user", user);
            object.put("success", true);
            object.put("uid", user.getUid());
        }
        else object.put("success", false);

        out.print(object.toJSONString());
    }
}
