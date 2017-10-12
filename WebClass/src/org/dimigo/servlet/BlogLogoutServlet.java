package org.dimigo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BlogLogoutServlet", urlPatterns = "/bloglogout")
public class BlogLogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        session.removeAttribute("user");
        session.invalidate();
//        RequestDispatcher rd = request.getRequestDispatcher("myblog/index.jsp");
//        rd.forward(request, response);



        response.sendRedirect("myblog/index.jsp");
    }


}
