package org.dimigo.servlet;

import org.dimigo.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. ArrayList 생성
        // 2. UserVO 객체를 담기 (3명)
        // 3.request에 ArrayList를 set하고, list.jsp로 포워딩

        List<UserVO> user = new ArrayList<>();


        user.add(new UserVO("D", "다시아", "전륜"));
        user.add(new UserVO("B", "버기", "후륜"));
        user.add(new UserVO("U", "UAZ", "사륜"));

        request.setAttribute("list", user);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
        rd.forward(request, response);

    }
}
