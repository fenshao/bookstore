package cn.ynni.bookstore.Filter;

import cn.ynni.bookstore.entity.Admin;
import cn.ynni.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if (uri.endsWith("Login.jsp") || uri.endsWith("doCheckEmail") || uri.endsWith("doRegister") || uri.endsWith("buyBook") || uri.endsWith("addCart") || uri.endsWith("addBook") || uri.endsWith("createOrder") || uri.endsWith("updateUser") || uri.endsWith("addUser") || uri.endsWith("doCheckUser") || uri.endsWith("doLogin") || uri.endsWith("bookinfo") || uri.endsWith("findBookList") || uri.endsWith(".json") || uri.endsWith(".woff") || uri.endsWith(".woff2") || uri.endsWith(".eot") || uri.endsWith(".svg") || uri.endsWith(".tff") || uri.endsWith("login") || uri.endsWith("dologin") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".jpg")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (uri.endsWith("admindoLogin") || uri.endsWith("updateorder") || uri.endsWith("userList") || uri.endsWith("bookList") || uri.endsWith("categoryList") || uri.endsWith("orderList")) {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            if (admin == null) {
                response.sendRedirect("/bookstore/admin/dologin");
            }
        }
        else {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect("/bookstore/Home/login");
                return;
            }
        }


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
