package org.dimigo.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet", urlPatterns = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");

        System.out.println("id : " + id + "\npwd : " + pwd + "\nname : " + name + "\nnickname : " + nickname);

        HttpSession session = request.getSession();

        boolean result = false;

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();

            if(result) {
                jsonObject.addProperty("msg", "success");
            } else {
                jsonObject.addProperty("msg", "error");
                //obj.addProperty("detail", Message.getMessage("E0002", id));
            }

            out.write(gson.toJson(jsonObject));
            out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
        rd.forward(request, response);
    }
}
