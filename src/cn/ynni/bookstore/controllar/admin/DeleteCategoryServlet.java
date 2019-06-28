package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");

        new CategoryService().delete(cid);

        resp.sendRedirect("/bookstore/admin/categoryList");
    }
}
