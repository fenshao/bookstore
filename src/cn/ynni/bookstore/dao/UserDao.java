package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner runner = null; //查询运行器

    public UserDao() {
        this.runner = new TxQueryRunner();
    }

    /*************************************
     * 功能：添加用户
     * @parm user
     *************************************/
    public int add(User user) throws SQLException {
        String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?)";
        Object[] objects = {
                user.getUid(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getCode(), user.getState(), user.getAddress()
        };

        int row = runner.update(sql, objects);

        return row;
    }

    /*************************************
     * 功能：修改用户
     * @parm user
     *************************************/
    public void update(User user) throws SQLException {
        String sql = "update user set username = ?, password = ?,email = ?, state = ?, address = ? where uid = ?";
        Object[] objects = {
                user.getUsername(), user.getPassword(), user.getEmail(),
                user.getState(),  user.getAddress(), user.getUid(),
        };

        runner.update(sql, objects);
    }

    public void updateInfo(User user) throws SQLException {
        String sql = "update user set username = ?, email = ?, state = ?, address = ? where uid = ?";
        Object[] objects = {
                user.getUsername(),  user.getEmail(),
                user.getState(),  user.getAddress(), user.getUid(),
        };

        runner.update(sql, objects);
    }

    /*************************************
     * 功能：根据id删除
     * @parm id
     *************************************/
    public void delete(String id) throws SQLException {
        String sql = "delete from user where uid = ?";

        runner.update(sql, id);
    }

    /*************************************
     * 功能：根据id查询一个用户
     * @parm id
     ************************************/
    public User findById(String uid) throws SQLException {
        String sql = "select * from user where uid = ?";

        User user = runner.query(sql, new BeanHandler<User>(User.class), uid);

        return user;
    }

    /*************************************
     * 功能：根据code查询一个用户
     * @parm code
     ************************************/
    public User findByCode(String code) throws SQLException {
        String sql = "select * from user where code = ?";

        User user = runner.query(sql, new BeanHandler<User>(User.class), code);

        return user;
    }

    /*************************************
     * 功能：根据name查询一个用户
     * @parm name
     ************************************/
    public User findByName(String name) throws SQLException {
        String sql = "select * from user where username = ?";

        User user = runner.query(sql, new BeanHandler<User>(User.class), name);

        return user;
    }

    /*************************************
     * 功能：根据email查询一个用户
     * @parm email
     ************************************/
    public User findByEmail(String email) throws SQLException {
        String sql = "select * from user where email = ?";

        User user = runner.query(sql, new BeanHandler<User>(User.class), email);

        return user;
    }

    /*************************************
     * 功能：查询所有用户
     *************************************/
    public List<User> findAll() throws SQLException {
        String sql = "select * from user";

        List<User> users = runner.query(sql, new BeanListHandler<User>(User.class));

        return users;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int userCount()throws SQLException{
        String sql = "select count(uid) from user";

        Object obj = runner.query(sql, new ScalarHandler());

        return Integer.parseInt(String.valueOf(obj));
    }

    public List<User> list(int start, int count) throws SQLException {
        String sql = "select * from user order by id desc limit ?,? ";

        List<User> users = runner.query(sql, new BeanListHandler<User>(User.class), start, count);


        return users;
    }

}
