package org.dimigo.action;

import org.dimigo.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAction implements IAction{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("jsp/login.jsp");

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/sessionInfo.jsp");
            rd.forward(request, response);
        }

    }
}
