package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.OrderItemDao;
import cn.ynni.bookstore.entity.Orderitem;

import java.sql.SQLException;
import java.util.List;

public class OrderItemService {

    public boolean add(Orderitem orderitem) {
        OrderItemDao orderItemDao = new OrderItemDao();
        int row = 0;

        try {
            row = orderItemDao.add(orderitem);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row != 0;
    }

    public int itemCount() {
        OrderItemDao orderItemDao = new OrderItemDao();
        int count = 0;

        try {
            count = orderItemDao.itemCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<Orderitem> findByOid(String oid) {
        OrderItemDao orderItemDao = new OrderItemDao();
        List<Orderitem> orderitems = null;

        try {
            orderitems = orderItemDao.findByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderitems;
    }

    public void delete(String oid) {
        OrderItemDao orderItemDao = new OrderItemDao();

        try {
            orderItemDao.delete(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
