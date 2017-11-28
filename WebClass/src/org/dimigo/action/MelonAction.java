package org.dimigo.action;

import org.dimigo.User.Music;
import org.dimigo.service.MelonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MelonAction implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
//        request.setCharacterEncoding("x-windows-949");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            MelonService melon = new MelonService();
            String json = melon.search();
            List<Music> list = melon.parseJson(json);

            request.setAttribute("chart", list);


            RequestDispatcher rd = request.getRequestDispatcher("myblog/melon.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "오류가 발생했습니다.");
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("myblog/melonsearch.jsp");
            rd.forward(request, response);
        }

    }

}
