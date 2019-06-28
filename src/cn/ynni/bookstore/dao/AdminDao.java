package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Admin;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDao {

    private QueryRunner runner = null; //查询运行器

    public AdminDao() {
        this.runner = new TxQueryRunner();
    }

    public Admin findByName(String name, String password) throws SQLException {
        String sql = "select * from admin where username = ? and password = ?";

        Admin user = runner.query(sql, new BeanHandler<Admin>(Admin.class), name, password);

        return user;
    }
}
