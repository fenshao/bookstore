package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.CategoryDao;
import cn.ynni.bookstore.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    public List<Category> findAll() {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = null;

        try {
            categories = categoryDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public Category findById(String cid) {
        Category category = new Category();

        try {
            category = new CategoryDao().findById(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    public void delete(String id) {

        try {
            new CategoryDao().delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Category category) {

        try {
            new CategoryDao().update(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Category category) {

        try {
            new CategoryDao().add(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int userCount() {
        int row = 0;

        try {
            row = new CategoryDao().userCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

}
