package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        // 세션 무효화
        session.invalidate();

        RequestDispatcher rd = request.getRequestDispatcher("myblog/index.jsp");
        rd.forward(request, response);
    }
}
