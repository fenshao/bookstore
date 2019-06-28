package cn.ynni.bookstore.dao;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.utils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner runner = null; //查询运行器

    public BookDao() {
        this.runner = new TxQueryRunner();
    }

    /*************************************
     * 功能：添加种类
     * @parm category
     *************************************/
    public int add(Book book) throws SQLException {
        String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?)";
        Object[] objects = {
                book.getBid(), book.getBname(), book.getPrice(),
                book.getAuthor(), book.getImage(), book.getCid(), book.getBname() + book.getAuthor()
        };

        int row = runner.update(sql, objects);

        return row;
    }

    /*************************************
     * 功能：修改种类
     * @parm category
     *************************************/
    public void update(Book book) throws SQLException {
        String sql = "update book set bname = ?, price = ?, author = ?, image = ?, cid = ? where bid = ?";
        Object[] objects = {
                book.getBname(), book.getPrice(), book.getAuthor(),
                book.getImage(), book.getCid(), book.getBid()
        };

        runner.update(sql, objects);
    }

    /*************************************
     * 功能：根据id删除种类
     * @parm id
     *************************************/
    public void delete(String bid) throws SQLException {
        String sql = "delete from book where bid = ?";

        runner.update(sql, bid);
    }

    /*************************************
     * 功能：根据id查询一个分类
     * @parm id
     ************************************/
    public List<Book> findById(String cid) throws SQLException {
        String sql = "select * from book where cid = ?";

        List<Book> books = runner.query(sql, new BeanListHandler<Book>(Book.class), cid);

        return books;
    }

    public Book findByBId(String bid) throws SQLException {
        String sql = "select * from book where bid = ?";

        Book book = runner.query(sql, new BeanHandler<Book>(Book.class), bid);

        return book;
    }


    /*************************************
     * 功能：查询所有分类
     *************************************/
    public List<Book> findAll() throws SQLException {
        String sql = "select * from book";

        List<Book> books = runner.query(sql, new BeanListHandler<Book>(Book.class));

        return books;
    }

    /*************************************
     * 功能：查询一共多少记录
     * @parm id
     *************************************/
    public int userCount()throws SQLException{
        String sql = "select count(bid) from book";

        Object obj = runner.query(sql, new ScalarHandler());

        return Integer.parseInt(String.valueOf(obj));
    }
}
