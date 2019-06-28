package cn.ynni.bookstore.controllar.fore;

import cn.ynni.bookstore.entity.Category;
import cn.ynni.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findAll();

        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/Home/Index.jsp").forward(req, resp);
    }
}
