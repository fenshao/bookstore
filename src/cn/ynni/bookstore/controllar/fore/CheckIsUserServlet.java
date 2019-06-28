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

public class CheckIsUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");

        UserService userService = new UserService();
        JSONObject object = new JSONObject();

        object.put("success", userService.findUserByName(username));
        out.print(object.toJSONString());
        out.close();
    }
}
