package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddCatagoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categoryList = new CategoryService().findAll();

        req.setAttribute("categories", categoryList);

        req.getRequestDispatcher("/admin/admincategorylist.jsp").forward(req, resp);
    }
}
