package dimigo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = ("/HelloServlet"))
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        response.getWriter().append("Served at :").append(request.getContextPath());
        // 입력데이터 처리
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println("id : " + id + " name : " + name);


        // 출력데이터 Content Type 설정
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Test</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, Servlet</h1>");
        out.println("<h1>안녕, 서블릿</h1>");
        out.println("<h2>id : " + id + " name : " + name + "</h2>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost() 호출");
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {

        System.out.println("init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.service(req, resp);
        System.out.println("service()");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }



}
