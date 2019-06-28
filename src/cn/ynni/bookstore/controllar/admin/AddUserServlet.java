package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.UserService;
import cn.ynni.bookstore.utils.CodeUtil;
import cn.ynni.bookstore.utils.MailUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUid(CodeUtil.generateUniqueCode());
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setState(Integer.parseInt(req.getParameter("state")));
        user.setEmail(req.getParameter("email"));
        user.setCode(CodeUtil.generateUniqueCode());

        new UserService().add(user);

        JSONObject object = new JSONObject();

        object.put("success", true);
        object.put("msg", "新增学生成功");

        resp.getWriter().print(object.toJSONString());
    }
}
