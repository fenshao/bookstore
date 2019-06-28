package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Orderitem;
import cn.ynni.bookstore.entity.Orders;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {
    private QueryRunner runner = null; //查询运行器

    public OrderItemDao() {
        this.runner = new TxQueryRunner();
    }

    /*************************************
     * 功能：添加种类
     * @parm category
     *************************************/
    public int add(Orderitem orderitem) throws SQLException {
        String sql = "INSERT INTO orderitem VALUES(?, ?, ?, ?, ?)";
        Object[] objects = {
                orderitem.getIid(), orderitem.getCount(), orderitem.getSubtotal(),
                orderitem.getOrders().getOid(), orderitem.getBook().getBid()
        };

        int row = runner.update(sql, objects);

        return row;
    }

    /*************************************
     * 功能：修改种类
     * @parm category
     *************************************/
    public void update(Orderitem orderitem) throws SQLException {
        String sql = "update orderitem set COUNT = ?, subtotal = ?,  where iid = ?";
        Object[] objects = {
                orderitem.getCount(), orderitem.getSubtotal(),
                orderitem.getIid()
        };

        runner.update(sql, objects);
    }

    /*************************************
     * 功能：根据id删除种类
     * @parm id
     *************************************/
    public void delete(String oid) throws SQLException {
        String sql = "delete from orderitem where oid = ?";

        runner.update(sql, oid);
    }

    /*************************************
     * 功能：根据id查询一个分类
     * @parm id
     ************************************/
    public Orderitem findById(String iid) throws SQLException {
        String sql = "select * from orderitem where iid = ?";

        Orderitem orderitem = runner.query(sql, new BeanHandler<Orderitem>(Orderitem.class), iid);

        return orderitem;
    }

    /*************************************
     * 功能：查询所有分类
     *************************************/
    public List<Orderitem> findByOid(String oid) throws SQLException {
        String sql = "select * from orderitem where oid = ?";

        List<Orderitem> orderitems = runner.query(sql, new BeanListHandler<Orderitem>(Orderitem.class), oid);

        return orderitems;
    }

    /*************************************
     * 功能：查询所有分类
     *************************************/
    public List<Orderitem> findAll() throws SQLException {
        String sql = "select * from orderitem";

        List<Orderitem> orderitems = runner.query(sql, new BeanListHandler<Orderitem>(Orderitem.class));

        return orderitems;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int itemCount()throws SQLException{
        String sql = "select count(iid) from orderitem";

        Object obj = runner.query(sql, new ScalarHandler());

        return Integer.parseInt(String.valueOf(obj));
    }
}
