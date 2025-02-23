package com.admin.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String bookName = req.getParameter("bname");
            String author = req.getParameter("author");
            String price = req.getParameter("price");
            String categories = req.getParameter("categories");
            String status = req.getParameter("status");
            Part part = req.getPart("bimg");
            String filename = part.getSubmittedFileName();

            BookDtls b = new BookDtls(bookName, author, price, categories, status, filename, "admin");

            // System.out.println(b);
            BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());

            boolean f = dao.addBook(b);

            HttpSession session = req.getSession();

            if (f) {
                String path = getServletContext().getRealPath("")+"book";
                System.out.println(path);
    
                // File file = new File(path);
                part.write(path+File.separator+filename);

                session.setAttribute("succMsg", "Book Added Successfully");
                resp.sendRedirect("admin/add_books.jsp");
            } else {
                session.setAttribute("failedMsg", "Something went wrong");
                resp.sendRedirect("admin/add_books.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
