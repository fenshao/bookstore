package cn.ynni.bookstore.controllar.fore;

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
import java.io.PrintWriter;

public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = CodeUtil.generateUniqueCode();

        User user = new User();
        user.setState(0);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCode(code);

        UserService userService = new UserService();
        boolean row = userService.register(user);

        JSONObject object = new JSONObject();
        if (row) { //注册成功
            object.put("success", true);

            //发送邮件
            MailUtil mailUtil = new MailUtil(email, code);
            mailUtil.run();
        }
        else {
            object.put("success", false);
        }

        out.print(object.toJSONString());

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
