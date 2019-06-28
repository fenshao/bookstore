package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner runner = null; //查询运行器

    public CategoryDao() {
        this.runner = new TxQueryRunner();
    }

    /*************************************
     * 功能：添加种类
     * @parm category
     *************************************/
    public int add(Category category) throws SQLException {
        String sql = "INSERT INTO category VALUES(?, ?)";
        Object[] objects = {
                category.getCid(), category.getCname()
        };

        int row = runner.update(sql, objects);

        return row;
    }

    /*************************************
     * 功能：修改种类
     * @parm category
     *************************************/
    public void update(Category category) throws SQLException {
        String sql = "update category set cname = ? where cid = ?";
        Object[] objects = {
                category.getCname(), category.getCid()
        };

        runner.update(sql, objects);
    }

    /*************************************
     * 功能：根据id删除种类
     * @parm id
     *************************************/
    public void delete(String id) throws SQLException {
        String sql = "delete from category where cid = ?";

        runner.update(sql, id);
    }

    /*************************************
     * 功能：根据id查询一个分类
     * @parm id
     ************************************/
    public Category findById(String cid) throws SQLException {
        String sql = "select * from category where cid = ?";

        Category category = runner.query(sql, new BeanHandler<Category>(Category.class),cid);

        return category;
    }


    /*************************************
     * 功能：查询所有分类
     *************************************/
    public List<Category> findAll() throws SQLException {
        String sql = "select * from category";

        List<Category> categories = runner.query(sql, new BeanListHandler<Category>(Category.class));

        return categories;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int userCount()throws SQLException{
        String sql = "select count(cid) from category";

        Object obj = runner.query(sql, new ScalarHandler());

        return Integer.parseInt(String.valueOf(obj));
    }
}
