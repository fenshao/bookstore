package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.UserDao;
import cn.ynni.bookstore.entity.User;
import cn.ynni.bookstore.utils.CodeUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    /*****************************************
     * @Describe 注册用户
     * @param user
     * @return 注册是否成功
     ****************************************/
    public boolean register(User user) {
        UserDao userDao = new UserDao();
        user.setUid(CodeUtil.generateUniqueCode());
        int row = 0;

        try {
            row = userDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row != 0;
    }

    public User findUserById(String uid) {
        UserDao userDao = new UserDao();
        User user = null;

        try {
            user = userDao.findById(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*****************************************
     * @Describe 通过name查询用户
     * @param name
     ****************************************/
    public boolean findUserByName(String name) {
        UserDao userDao = new UserDao();
        User user = null;

        try {
            user = userDao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //返回true 说明用户名存在
        if (user != null && user.getUsername() != null) return true;
        else return false;
    }

    /*****************************************
     * @Describe 通过email查询用户
     * @param email
     ****************************************/
    public boolean findUserByEmail(String email) {
        UserDao userDao = new UserDao();
        User user = null;

        try {
            user = userDao.findByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null && user.getEmail() != null) return true;
        else return false;
    }

    /*****************************************
     * @Describe 通过email查询用户
     * @param code
     ****************************************/
    public User findUserByCode(String code) {
        UserDao userDao = new UserDao();
        User user = null;

        try {
            user = userDao.findByCode(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*****************************************
     * @Describe 修改state的值
     * @param user
     ****************************************/
    public void updateState(User user) {
        UserDao userDao = new UserDao();
        try {
            user.setState(1);
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*****************************************
     * @Describe 登录
     * @param username
     ****************************************/
    public User dologin(String username) {
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.findByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> findAll() {
        UserDao userDao = new UserDao();
        List<User> users = new ArrayList<User>();

        try {
            users = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void updateInfo(User user) {
        UserDao userDao = new UserDao();

        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String uid) {

        try {
            new UserDao().delete(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            new UserDao().add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {

        try {
            new UserDao().update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> list(int start, int count) {
        List<User> users = new ArrayList<User>();

        try {
            users = new UserDao().list(start, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
