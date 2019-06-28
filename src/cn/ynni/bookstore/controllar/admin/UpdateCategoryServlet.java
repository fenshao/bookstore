package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String cname =req.getParameter("cname");

        Category category = new Category();

        category.setCid(cid);
        category.setCname(cname);

        System.out.println(category.getCid());
        System.out.println(category.getCname());

        new CategoryService().update(category);

        resp.sendRedirect("/bookstore/admin/categoryList");
    }
}
