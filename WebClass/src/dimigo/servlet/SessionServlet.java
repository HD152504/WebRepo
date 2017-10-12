package dimigo.servlet;


import org.dimigo.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에 사용자 정보가 있는지 체크 (null 체크) 하고
        // 없으면 jsp/login.jsp 포워딩
        // 있으면 jsp/sessionInfo.jsp로 포워딩 (id, name, nickname을 출력)
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {

//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out = response.getWriter();
//
//            out.println("<script>");
//            out.println("alert('사용자 정보가 없습니다!');");
//            out.println("</script>");

            response.sendRedirect("jsp/login.jsp");

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/sessionInfo.jsp");
            rd.forward(request, response);
        }

    }
}
