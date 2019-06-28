package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.OrdersDao;
import cn.ynni.bookstore.entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersService {

    public void add(Orders orders) {
        OrdersDao ordersDao = new OrdersDao();

        try {
            ordersDao.add(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int orderCount() {
        OrdersDao ordersDao = new OrdersDao();

        int count = 0;
        try {
            count = ordersDao.orderCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public Orders findById(String oid) {
        OrdersDao ordersDao = new OrdersDao();
        Orders orders = null;

        try {
            orders = ordersDao.findById(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public void delete(String oid) {
        OrdersDao ordersDao = new OrdersDao();

        try {
            ordersDao.delete(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Orders orders) {
        OrdersDao ordersDao = new OrdersDao();

        try {
            ordersDao.update(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Orders> findAll() {
        List<Orders> orders = new ArrayList<Orders>();

        try {
            orders = new OrdersDao().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
