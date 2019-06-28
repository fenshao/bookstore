package cn.ynni.bookstore.controllar.admin;

import cn.ynni.bookstore.entity.Book;
import cn.ynni.bookstore.service.BookService;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = null, bname = null, price = null, author = null, category = null;

        Book book = new Book();

        String upLoadDir = this.getServletContext().getRealPath("/images");
        new File(upLoadDir);

        DiskFileUpload fu = new DiskFileUpload();
        fu.setSizeMax(524288000L);
        fu.setSizeThreshold(1048576);
        fu.setHeaderEncoding("utf-8");
        List fileItem = null;

        try {
            fileItem = fu.parseRequest(req);
        } catch (FileUploadException var21) {
            var21.printStackTrace();
        }

        Iterator it = fileItem.iterator();

        String path = null;
        while(it.hasNext()) {
            FileItem fitem = (FileItem)it.next();
            if (!fitem.isFormField()) {
                String pathSrc = fitem.getName();
                if (!pathSrc.trim().equals("")) {
                    int start = pathSrc.lastIndexOf(92);
                    String fileName = pathSrc.substring(start + 1);
                    path = fileName;
                    File pathDest = new File(upLoadDir, fileName);

                    try {
                        fitem.write(pathDest);
                    } catch (Exception var19) {
                        var19.printStackTrace();
                    } finally {
                        fitem.delete();
                    }
                }
            }
            else {
                String name = fitem.getFieldName();
                if ("bid".equals(name)) bid = fitem.getString("utf-8");
                else if ("bname".equals(name)) bname = fitem.getString("utf-8");
                else if ("price".equals(name)) price = fitem.getString("utf-8");
                else if ("author".equals(name)) author = fitem.getString("utf-8");
                else if ("category".equals(name)) category = fitem.getString("utf-8");
            }
        }

        book.setPrice(Double.parseDouble(price));
        book.setCid(category);
        book.setBid(bid);
        book.setAuthor(author);
        book.setBname(bname);
        book.setImage(path == null ? new BookService().findByBId(bid).getImage() : "images/" + path);

        new BookService().update(book);

        resp.sendRedirect("/bookstore/admin/bookList");

    }
}
