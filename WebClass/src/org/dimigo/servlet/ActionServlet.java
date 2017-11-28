package org.dimigo.servlet;

import org.dimigo.action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ActionServlet", urlPatterns = {"*.do"})
public class ActionServlet extends HttpServlet {

    private Map<String, IAction> actions = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // 서블릿로딩 될 때 최초에만 한번 실행
        actions.put("login", new LoginAction());
        actions.put("logout", new LogoutAction());
        actions.put("session", new SessionAction());
        actions.put("list", new ListAction());
        actions.put("signup", new SignUpAction());
        actions.put("weather", new WeatherAction());
        actions.put("melon", new MelonAction());
        actions.put("write", new WriteAction());
        actions.put("naver", new NaverAction());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. uri (/login.do)
            String uri = request.getRequestURI();
            System.out.println("uri : " + uri);

            String actionName = uri.substring(uri.lastIndexOf("/") + 1);
            actionName = actionName.substring(0, actionName.indexOf("."));
            System.out.println("actionName : " + actionName);

            // 2. action 객체를 갖고오기
            IAction action = actions.get(actionName);

            if (action == null) {
                throw new Exception("There is no" + actionName + " Action Class");
            }

            //XXAction의 execute() 실행
            action.execute(request, response);


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
            rd.forward(request, response);
        }
    }

}
