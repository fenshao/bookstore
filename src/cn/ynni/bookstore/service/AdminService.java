package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.AdminDao;
import cn.ynni.bookstore.entity.Admin;

import java.sql.SQLException;

public class AdminService {

    public Admin findByName(String name, String password) {
        Admin admin = null;

        try {
            admin = new AdminDao().findByName(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
