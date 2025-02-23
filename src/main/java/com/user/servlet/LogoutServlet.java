package com.user.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import jakarta.servlet.ServletException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            session.removeAttribute("userobj");
            session.invalidate();

            HttpSession newSession = req.getSession(true); // Create a new session
            newSession.setAttribute("succMsg", "Logout Successfully");
            resp.sendRedirect("login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}