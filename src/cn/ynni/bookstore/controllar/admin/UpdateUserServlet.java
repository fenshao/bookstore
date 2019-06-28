package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();

        user.setUid(req.getParameter("uid"));
        user.setEmail(req.getParameter("email"));
        user.setUsername(req.getParameter("username"));
        user.setState(Integer.parseInt(req.getParameter("state")));
        user.setAddress(req.getParameter("address"));
        user.setPassword(req.getParameter("password"));

        new UserService().updateInfo(user);

        JSONObject object = new JSONObject();

        object.put("success", true);
        object.put("msg", "修改成功！");

        resp.getWriter().print(object.toJSONString());
    }
}
