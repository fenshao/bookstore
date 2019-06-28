package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("icname");

        Category category = new Category();

        category.setCname(cname);
        System.out.println(category.getCname());
        category.setCid(Integer.toString(new CategoryService().userCount() + 1));

        new CategoryService().add(category);

        resp.sendRedirect("/bookstore/admin/categoryList");
    }
}
