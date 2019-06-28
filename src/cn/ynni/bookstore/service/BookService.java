package cn.ynni.bookstore.service;

import cn.ynni.bookstore.dao.BookDao;
import cn.ynni.bookstore.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public List<Book> findById(String cid) {
        List<Book> books = null;
        BookDao bookDao = new BookDao();

        try {
            books = bookDao.findById(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book findByBId(String bid) {
        Book book = null;
        BookDao bookDao = new BookDao();

        try {
            book = bookDao.findByBId(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<Book>();

        try {
            bookList = new BookDao().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public void update(Book book) {
        try {
            new BookDao().update(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int userCount() {
        int row = 0;

        try {
            row = new BookDao().userCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    public void add(Book book) {

        try {
            new BookDao().add(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String bid) {

        try {
            new BookDao().delete(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
