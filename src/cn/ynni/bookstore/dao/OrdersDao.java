package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrdersDao {
    private QueryRunner runner = null; //查询运行器

    public OrdersDao() {
        this.runner = new TxQueryRunner();
    }

    /*************************************
     * 功能：添加种类
     * @parm category
     *************************************/
    public int add(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?, ?, ?, ?)";
        Object[] objects = {
            orders.getOid(), orders.getOrdertime(), orders.getPrice(),
            orders.getState(), orders.getUser().getUid(), orders.getUser().getAddress()
        };

        int row = runner.update(sql, objects);

        return row;
    }

    /*************************************
     * 功能：修改种类
     * @parm category
     *************************************/
    public void update(Orders orders) throws SQLException {
        String sql = "update orders set price = ?, state = ?, address = ? where oid = ?";
        Object[] objects = {
                orders.getPrice(), orders.getState(), orders.getAddress(),
                orders.getOid()
        };

        runner.update(sql, objects);
    }

    /*************************************
     * 功能：根据id删除种类
     * @parm id
     *************************************/
    public void delete(String oid) throws SQLException {
        String sql = "delete from orders where oid = ?";

        runner.update(sql, oid);
    }

    /*************************************
     * 功能：根据id查询一个分类
     * @parm id
     ************************************/
    public Orders findById(String oid) throws SQLException {
        String sql = "select * from orders where oid = ?";

        Orders order = runner.query(sql, new BeanHandler<Orders>(Orders.class), oid);

        return order;
    }

    /*************************************
     * 功能：查询所有分类
     *************************************/
    public List<Orders> findAll() throws SQLException {
        String sql = "select * from orders";

        List<Orders> orders = runner.query(sql, new BeanListHandler<Orders>(Orders.class));

        return orders;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int orderCount()throws SQLException{
        String sql = "select count(oid) from orders";

        Object obj = runner.query(sql, new ScalarHandler());

        return Integer.parseInt(String.valueOf(obj));
    }

}
