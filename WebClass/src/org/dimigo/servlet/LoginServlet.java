package org.dimigo.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//import org.json.simple.JSONObject;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at :").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
//        System.out.println("id : " + id + " pwd : " + pwd);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

//        {
//            "id" : "testid"
//        }
//

//        out.println("{");
//        out.println("\"id\" : " + "\"" + id + "\"");
//        out.println("}");

        // JSON Simple Library
//        JSONObject json = new JSONObject();
//        json.put("id", id);
//        System.out.println(json.toJSONString());
//        out.write(json.toJSONString());

        // Gson Library 사용해서 소스 작성하기

        Gson gson = new Gson();
        JsonObject json = new JsonObject();
        json.addProperty("id",id);
        out.write(gson.toJson(json));


        out.close();
    }

}
