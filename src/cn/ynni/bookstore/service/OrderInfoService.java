package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.OrderInfoDao;
import cn.ynni.bookstore.entity.OrderInfo;
import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderInfoService {

    public List<OrderInfo> findAll(User user) {
        OrderInfoDao orderInfoDao = new OrderInfoDao();
        List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
        List<Orders> orders = null;

        try {
            orders = orderInfoDao.findAll(user.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (Orders os: orders) {
            OrderInfo info = new OrderInfo();

            info.setOid(os.getOid());
            info.setPrice(os.getPrice());
            info.setState(os.getState());
            try {
                info.setSum(orderInfoDao.itemCount(os.getOid()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            orderInfos.add(info);
        }

        return orderInfos;
    }

    public int itemCount(String oid) {
        OrderInfoDao orderInfoDao = new OrderInfoDao();
        int num = 0;

        try {
            num = orderInfoDao.itemCount(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }
}
