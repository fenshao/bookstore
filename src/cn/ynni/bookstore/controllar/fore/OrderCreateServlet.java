package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.service.OrderItemService;
import cn.ynni.bookstore.service.OrdersService;
import cn.ynni.bookstore.utils.CodeUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numbers = req.getParameterValues("numbers");
        User u = (User) req.getSession().getAttribute("user");

        JSONObject object = new JSONObject();
        if (null == numbers) {
            object.put("success", false);
            object.put("msg", "订单创建失败！购物车为空！");

            resp.getWriter().print(object.toJSONString());
            return;
        }

        //转换成整数
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        if(null == u){

            object.put("success", false);
            object.put("msg", "请登录");
            resp.getWriter().print(object.toJSONString());

            return;
        }

        Orders orders = new Orders();
        orders.setUser(u);
        orders.setOrdertime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orders.setState(0);

        List<Orderitem> orderitems = (List<Orderitem>)req.getSession().getAttribute("ois");

        double price = 0.0;
        for (int i = 0; i < orderitems.size(); i++) {
            double total = orderitems.get(i).getBook().getPrice() * nums[i];
            price += total;
            orderitems.get(i).setSubtotal(total);
        }

        orders.setPrice(price);
        orders.setOid(CodeUtil.generateUniqueCode());
        new OrdersService().add(orders);


        for (Orderitem oi: orderitems) {
            oi.setOrders(orders);
            oi.setIid(Integer.toString(new OrderItemService().itemCount() + 1));
            new OrderItemService().add(oi);
            price += oi.getBook().getPrice();
        }

        orderitems.clear();

        object.put("success", true);
        object.put("msg", "订单创建成功！请到订单管理查看！");

        resp.getWriter().print(object.toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
