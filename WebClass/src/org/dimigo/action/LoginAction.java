package org.dimigo.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginAction implements IAction {

    public void validate(String id, String pwd) throws Exception {
        if (CommonUtil.isEmpty(id)) {
            throw new Exception("아이디를 입력하세요");
        }
        if (CommonUtil.isEmpty(pwd)) {
            throw new Exception("비밀번호를 입력하세요");
        }
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        try {


            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");

            // 2.  입력값 검증
            validate(id, pwd);

            UserVO user = new UserVO();
            user.setId(id);
            user.setPwd(pwd);

            // 3. Service 호출
            UserService service = new UserService();
            UserVO result = service.login(user);

            System.out.println("id : " + result.getId() + " pwd : " + result.getPwd());


            HttpSession session = request.getSession();

            System.out.println(result.getName());

            jsonObject.addProperty("msg", "success");

            jsonObject.addProperty("name", result.getName());

            session.setAttribute("user", result);
            session.setAttribute("username", result.getName());


        } catch (Exception e) {

            jsonObject.addProperty("msg", "error");
            //obj.addProperty("detail", Message.getMessage("E0002", id));

        } finally {
            out.write(gson.toJson(jsonObject));
            out.close();
        }

    }


}
