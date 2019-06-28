package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderInfoDao {
    private QueryRunner runner = null; //查询运行器

    public OrderInfoDao() {
        this.runner = new TxQueryRunner();
    }

    public List<Orders> findAll(String uid) throws SQLException {
        String sql = "select * from orders where uid = ?";

        List<Orders> orders = runner.query(sql, new BeanListHandler<Orders>(Orders.class), uid);

        return orders;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int itemCount(String oid)throws SQLException{
        String sql = "select sum(COUNT) from orderitem where oid = ?";

        Object obj = runner.query(sql, new ScalarHandler(), oid);

        return Integer.parseInt(String.valueOf(obj));
    }

}
