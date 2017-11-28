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

public class SignUpAction implements IAction {

    private void validate(UserVO vo) throws Exception {
        if(CommonUtil.isEmpty(vo.getId())) throw new Exception("아이디를 입력하세요");
        if(CommonUtil.isEmpty(vo.getPwd())) throw new Exception("비밀번호를 입력하세요");
        if(CommonUtil.isEmpty(vo.getName())) throw new Exception("이름를 입력하세요");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        try {
            // 1. 입력값 추출
            request.setCharacterEncoding("utf-8");
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");

            System.out.println("id : " + id + " pwd : " + pwd + " name : " + name);

            // 2. 입력값 검증
            UserVO user = new UserVO(id, pwd, name);

            validate(user);

            // 회원가입 처리
            UserService userService = new UserService();

            userService.signup(user);

            jsonObject.addProperty("msg", "success");

            jsonObject.addProperty("name", user.getName());


        } catch (Exception e) {
            jsonObject.addProperty("msg", "error");
            jsonObject.addProperty("error", e.getMessage());

            e.printStackTrace();
        } finally {
            out.write(gson.toJson(jsonObject));
            out.close();
        }

    }

    // ajax 방식
    //        request.setCharacterEncoding("utf-8");
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//
//
//        String id = request.getParameter("id");
//        String pwd = request.getParameter("pwd");
//        String name = request.getParameter("name");
//        String nickname = request.getParameter("nickname");
//
//        System.out.println("id : " + id + "\npwd : " + pwd + "\nname : " + name + "\nnickname : " + nickname);
//
//        boolean result = true;
//
//        Gson gson = new Gson();
//        JsonObject jsonObject = new JsonObject();
//
//        if(result) {
//            jsonObject.addProperty("msg", "success");
//        } else {
//            jsonObject.addProperty("msg", "error");
//        }
//
//        out.write(gson.toJson(jsonObject));
//        out.close();


}
