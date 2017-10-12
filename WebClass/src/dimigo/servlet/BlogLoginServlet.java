package dimigo.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.dimigo.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BlogLoginServlet", urlPatterns = "/bloglogin")
public class BlogLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        System.out.println("id : " + id + "\npwd : " + pwd);

        boolean result = "test@naver.com".equals(id);

        HttpSession session = request.getSession();

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if(result) {
            jsonObject.addProperty("msg", "success");

            UserVO user = new UserVO();
            user.setId(id);
            user.setName("김남현");
            user.setNickname("라면");

            jsonObject.addProperty("name", "김남현");

            session.setAttribute("user", user);

        } else {
            jsonObject.addProperty("msg", "error");
            //obj.addProperty("detail", Message.getMessage("E0002", id));
        }

        out.write(gson.toJson(jsonObject));
        out.close();

    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
